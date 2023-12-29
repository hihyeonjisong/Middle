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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * commons-fileupload 모듈을 이용한 파일 업로드 예제 
 * @author PC-11
 *
 */
@WebServlet("/fileUpload.do")
public class fileUploadServlet extends HttpServlet {
	private static final String UPLOAD_DIR = "upload_files";
	//메모리 임계크기(이 크기가 넘어가면 레파지토리 위치에 임시파일로 저장됨)
	private static final int MEMORY_THRESHHOLD= 1024*1024*3;
	//파일1개당 최대 크기
	private static final long MAX_FILE_SIZE = 1024*1024*50;
	//요청파일최대크기
	private static final long MAX_REQUEST_SIZE = 1024*1024*50;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * System.out.println("==============================="); BufferedReader br =
		 * new BufferedReader( new InputStreamReader( req.getInputStream())); String
		 * readLine = ""; while((readLine=br.readLine())!=null) {
		 * System.out.println(readLine); }
		 * System.out.println("===============================");
		 */
		//Multipart Parsing 전 파라미터 정보 조회해보기
		System.out.println("멀티파트 파싱 전:"+req.getParameter("sender"));
		if(ServletFileUpload.isMultipartContent(req)) {
			Map<String , String> formMap = new HashMap<String, String>();
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MEMORY_THRESHHOLD);
			factory.setRepository(
					new File(System.getProperty("java.io.tmpdir")));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(MAX_REQUEST_SIZE);
			
			//웹애플리케이션 루트 디렉토리를 기준으로 업로드 경로 설정하기
			String uploadPath = getServletContext().getRealPath("/")
					+File.separator +UPLOAD_DIR;
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				List<FileItem> formItems = upload.parseRequest(req);
				
				if(formItems !=null && formItems.size()>0) {
					for(FileItem item: formItems) {
						if(!item.isFormField()) {//파일데이터인경우..
							String fileName = item.getName();
							String filePath = uploadPath+File.separator
									+fileName;
							
							File storeFile = new File(filePath);
							System.out.println(storeFile);
							item.write(storeFile);//업로드 파일저장
							System.out.println("업로드완료됨=>"+fileName);
							
						}else {
							formMap.put(item.getFieldName(), item.getString("UTF-8"));
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			//Multipart Parsing 후 파라미터정보 조회해보기
			System.out.println("멀티파트 파싱 후:"+formMap.get("sender"));
		}
	}
}
