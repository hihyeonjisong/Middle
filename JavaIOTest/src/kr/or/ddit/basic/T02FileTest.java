package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class T02FileTest {
	public static void main(String[] args) {
		
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");
		//exists
		if (f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
		}else {
			System.out.println(f1.getAbsolutePath() + "은 없는 파일입니다.");
			
			try {
				if(f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + " 파일을 새로 만들었습니다.");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (f2.exists()) {
			System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
		}else {
			System.out.println(f2.getAbsolutePath() + "은 없는 파일입니다.");
		}
		System.out.println("----------------------------------------");
		
		File f3 = new File("d:/D_Other");
		File[] files = f3.listFiles();
		
		for (File f : files) {
			System.out.print(f.getName() + " => ");
			if(f.isFile()) {
				System.out.println("파일");
			}else if(f.isDirectory()) {
				System.out.println("디렉토리(폴더)");
			}
		}
		System.out.println("========================================");
		
		String[] strFiles = f3.list();
		for (String strFile : strFiles) {
			System.out.println(strFile);
		}
		System.out.println("----------------------------------------");
		System.out.println();
		
		displayFileList(new File("d:/D_Other"));

	}

	private static void displayFileList(File dir) {
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
		
		//listFiles: 디렉토리 안의 모든 파일 목록 가져오기
		File[] files = dir.listFiles();
		
		//하위 디렉토리 인덱스 정보를 저장할 ArrayList 생성
		List<Integer> subDirList = new ArrayList<Integer>();
		
		//날짜출력 위한 포맷 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd a hh:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr = ""; //파일 속성정보(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = ""; //파일 용량
			
			if (files[i].isDirectory()) {
				attr = "<DIR>";
				subDirList.add(i);
			}else {
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : " "; //읽기권한
				attr += files[i].canWrite() ? "W" : " "; //쓰기권한
				attr += files[i].isHidden() ? "H" : " "; // 히든
			}
			System.out.printf("%s %-5s %12s %s\n",
					sdf.format(new Date(files[i].lastModified())),
					attr, size, files[i].getName());
		}
		int dirCount = subDirList.size(); //하위폴더개수
		int fileCount = files.length - dirCount; //폴더 제외한 파일 개수
		
		System.out.println(fileCount + " 개의 파일," + dirCount + " 개의 디렉토리(폴더)");
		System.out.println();
		//System.out.println(subDirList); //인덱스 값
		
		for (Integer idx : subDirList) {
			displayFileList(files[idx]);
		}
	}
}
