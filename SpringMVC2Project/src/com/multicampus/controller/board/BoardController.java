package com.multicampus.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.multicampus.biz.board.BoardListVO;
import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;
//import com.multicampus.biz.user.UserVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//@Autowired
	@Resource(name="xmlView")
	private View xmlView;
	
	//@Autowired
	@Resource(name="jsonView")
	private View jsonView;	
	
	@RequestMapping("/dataTransform.do")
	public ModelAndView transform(BoardVO vo, BoardListVO listVO, @RequestParam("format") String format){//게시판 글을 XML형태로 보여주기
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		listVO.setBoardList(boardList);
		ModelAndView mav = new ModelAndView();
		mav.addObject(listVO);
		
		if(format.equals("xml")) 	mav.setView(xmlView);
		if(format.equals("json")) mav.setView(jsonView);

		return mav;
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()){//업로드 정보가 있다면
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp";   // View  정보 저장
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
	//public String getBoardList(BoardVO vo, UserVO vo2, Model model) {
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		
		//model.addAttribute("usernameis",vo2.getName());
		
		return "getBoardList.jsp";   // View  정보 저장
	}		


}








