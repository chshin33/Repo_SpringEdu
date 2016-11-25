package com.multicampus.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
		// ModelAndView에 저장된 정보는 자동으로 request에 등록된다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board); // Model 정보 저장
		mav.setViewName("getBoard");   // View  정보 저장
		return mav;
	}

}





