package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 서블릿API 3부터 지원하는 Part인터페이스를 이용한 파일업로드 예제
 * 
 * @author PC-11
 *
 */
@MultipartConfig
@WebServlet("/fileUpload2.do")
public class fileUploadServlet2 extends HttpServlet {
	private static final String UPLOAD_DIR = "upload_files";
	// 메모리 임계크기(이 크기가 넘어가면 레파지토리 위치에 임시파일로 저장됨)
	private static final int MEMORY_THRESHHOLD = 1024 * 1024 * 3;
	// 파일1개당 최대 크기
	private static final long MAX_FILE_SIZE = 1024 * 1024 * 50;
	// 요청파일최대크기
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 50;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Multopart Parsing 전 파라미터 정보 조회해보기
		System.out.println("멀티파트 파싱 전:" + req.getParameter("sender"));

		// 웹 애플리케이션 루트 디렉토리를 기준으로 업로드 경로 설정하기
		String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			String fileName ="";
			for(Part part : req.getParts()) {
				System.out.println(part.getHeader("contene-disposition"));
				//name속성명 가져오기
				System.out.println("전송된 Part명:"+ part.getName());
				
				fileName = part.getSubmittedFileName();//전송된 파일명 가져오기
				if(fileName!=null && fileName.equals("")) {
					//폼필드가 아니거나 파일이 비어있지 않은 경우..(첨부파일인 경우..)
					//파일저장하기
					part.write(uploadPath+ File.separator+ fileName);
					System.out.println("파일명: "+ fileName+" 업로드완료!!");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
