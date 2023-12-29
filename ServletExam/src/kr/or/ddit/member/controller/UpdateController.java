package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/member/update.do")
public class UpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		IMemberService memService = MemberServiceImpl.getInstance();
		MemberVO mv = memService.getMember(memId);
		req.setAttribute("mv", mv);
		
		if(mv.getAtchFileId()>0) {
			AtchFileService fileService = AtchFileServiceImpl.getInstance();
			AtchFileVO atchFileVO = new AtchFileVO();
			atchFileVO.setAtchFileId(mv.getAtchFileId());
			
			List<AtchFileVO> atchFileList = 
					fileService.getAtchFileList(atchFileVO);
			//저장
			req.setAttribute("atchFileList", atchFileList);
			
	
	}
		req.getRequestDispatcher("/views/member/updateForm.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		String atchFildId = req.getParameter("AtchFileId");//기존 첨부파일ID
		
		//첨부파일 저장하기
		AtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		
		IMemberService memService = MemberServiceImpl.getInstance();
		MemberVO mv = new MemberVO(memId,memName, memTel,memAddr);
		if(atchFileVO ==null) {
			//신규첨부파일이 존재하지 않는 경우..
			mv.setAtchFileId(Long.parseLong(atchFildId));
		}else {//신규 첨부파일이 존재하는 경우..
			mv.setAtchFileId(atchFileVO.getAtchFileId());
		}
		
		
		
		int cnt = memService.modifyMemeber(mv);
		
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
