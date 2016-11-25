package com.multicampus.controller;

import java.util.HashMap;
import java.util.Map;

import com.multicampus.controller.board.DeleteBoardController;
import com.multicampus.controller.board.GetBoardController;
import com.multicampus.controller.board.GetBoardListController;
import com.multicampus.controller.board.InsertBoardController;
import com.multicampus.controller.board.UpdateBoardController;
import com.multicampus.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do",        new LoginController());
		mappings.put("/insertBoard.do",  new InsertBoardController());
		mappings.put("/updateBoard.do",  new UpdateBoardController());
		mappings.put("/deleteBoard.do",  new DeleteBoardController());
		mappings.put("/getBoard.do",     new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
	}

	public Controller getController(String path) {
		return mappings.get(path);
	}

}
