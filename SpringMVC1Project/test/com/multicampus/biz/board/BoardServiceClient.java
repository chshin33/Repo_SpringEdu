package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring IoC 컨테이너 구동
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring IoC 컨테이너로부터 BoardServiceImpl 객체 Lookup.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. Lookup한 객체 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("익명");
		vo.setContent("임시 내용...............");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
