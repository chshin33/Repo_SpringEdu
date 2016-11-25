package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ����
@Repository
public class BoardDAOIbatis {
	
	@Autowired
	private SqlMapClientTemplate ibatis;

	// CRUD ��� �޼ҵ�
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Ibatis ������� insertBoard() ��� ó��");
		ibatis.insert("insertBoard",vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Ibatis ������� updateBoard() ��� ó��");
		ibatis.insert("updateBoard",vo);

	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Ibatis ������� deleteBoard() ��� ó��");
		ibatis.insert("deleteBoard",vo);

	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Ibatis ������� getBoard() ��� ó��");
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}

	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Ibatis ������� getBoardList() ��� ó��");
		return ibatis.queryForList("getBoardList", vo);
	}
}











