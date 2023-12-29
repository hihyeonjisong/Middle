package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
@WebServlet("/member/deLete.do")
public class DeleteController  extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		IMemberService memService = MemberServiceImpl.getInstance();
		int cnt = memService.removeMember(memId);
		
		String msg ="";
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		req.getSession().setAttribute("msg", msg);
		
		//목록화면으로 리다이렉트 처리(회원 삭제 후의 목록 화면을 표시)
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
