package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.AtchFileService;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@MultipartConfig
@WebServlet("/member/insert.do")
public class InsertController extends HttpServlet {
	
	
	@Override //list띄워줌
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/insertForm.jsp").forward(req,resp);
	
	}

	@Override //입력받아 insert때림
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		
		//서비스 객체 생성
		AtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO atchFileVO = new AtchFileVO();
		
		//첨부파일 목록 저장하기(공통기능 사용)
		atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		//회원정보 저장		
		IMemberService memService = MemberServiceImpl.getInstance();
		MemberVO mv = new MemberVO(memId,memName, memTel,memAddr);
		if(atchFileVO !=null) {
		mv.setAtchFileId(atchFileVO.getAtchFileId());
		}
		int cnt = memService.registMemeber(mv);
		
		String msg = "";
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		//목록화면으로 포워딩처리
		//req.getRequestDispatcher("/member/list.do").forward(req, resp);
		
		//목록화면으로 리다이렉팅처리
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
	}
}
