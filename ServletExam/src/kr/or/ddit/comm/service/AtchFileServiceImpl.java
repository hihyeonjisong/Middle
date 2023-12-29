package kr.or.ddit.comm.service;

import java.awt.PageAttributes.OriginType;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.http.Part;

import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.member.dao.AtchfileDaoImpl;
import kr.or.ddit.member.dao.IAtchfileDao;

public class AtchFileServiceImpl implements AtchFileService {
	private static final String UPLOAD_DIR = "upload_files";
	
	private IAtchfileDao fileDao;
	
	private static AtchFileService fileService;
	
	public AtchFileServiceImpl() {
		fileDao = (IAtchfileDao) AtchfileDaoImpl.getInstance();
	}
	
	public static AtchFileService getInstance() {
		if(fileService ==null) {
			fileService = new AtchFileServiceImpl();
		}
		
		return fileService;
	}
	
	
	@Override
	public AtchFileVO saveAtchFileList(Collection<Part> parts) {
		String uploadPath = "d:/D_Other/"+UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		boolean isFirstFile =true; //첫번째 파일여부
		AtchFileVO atchFileVO = null;
		
		for(Part part: parts) {
			String fileName = part.getSubmittedFileName();
			if(fileName != null && !fileName.equals("")) {
				if(isFirstFile) {
					isFirstFile = false;
					//파일 기본정보 저장하기
					atchFileVO = new AtchFileVO();
					fileDao.insertAtchFile(atchFileVO);				
				}
				//파일세부정보 저장하기
				String orignFileName = fileName; //원본파일명
				long fileSize = part.getSize(); //파일 사이즈
				String saveFileName = "";//저장파일명
				String saveFilePath = "";//저장파일경로
				
				saveFileName = UUID.randomUUID().toString().replace("-", "");
				saveFilePath = uploadPath+"/"+saveFileName;
				
				//업로드 파일 저장하기
				try {
					part.write(saveFilePath);
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					throw new RuntimeException("업로드 파일 저장중 예외발생!!",ex);
				}
				
				//확장자 추출
				String fileExt = orignFileName.lastIndexOf(".")< 0 ? "" :
					orignFileName.substring(orignFileName.lastIndexOf(".")+1);
				atchFileVO.setStreFileNm(saveFileName);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setOrignlFileNm(orignFileName);
				atchFileVO.setFileStreCours(saveFilePath);
				atchFileVO.setFileExtsn(fileExt);
				atchFileVO.setFileCn("");
				
				fileDao.insertAtchFileDetail(atchFileVO);
				try {
					part.delete();//임시 업로드 파일 삭제
				}catch(IOException e ) {
					throw new RuntimeException("업로드 파일 삭제중 예외발생",e);
				}
				
			}
		}
		return atchFileVO;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		List<AtchFileVO> atchFileList = fileDao.getAtchFileList(atchFileVO);
		return atchFileList;
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		return fileDao.getAtchFileDetail(atchFileVO);
	}
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}

}
