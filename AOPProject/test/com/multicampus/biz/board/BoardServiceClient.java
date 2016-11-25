package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring IoC �����̳� ����
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring IoC �����̳ʷκ��� BoardServiceImpl ��ü Lookup.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. Lookup�� ��ü �׽�Ʈ
		BoardVO vo = new BoardVO();
		//vo.setSeq(100);
		vo.setTitle("�ӽ� ����");
		vo.setWriter("�͸�");
		vo.setContent("�ӽ� ����...............");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}