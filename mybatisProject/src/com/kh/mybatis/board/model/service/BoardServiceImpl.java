package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardServiceImpl implements BoardService{

	@Override
	public int selectListCount() {
		return 0;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		return null;
	}

	@Override
	public int increaseCount(int boardNo) {
		return 0;
	}

	@Override
	public Board selectBoard(int boardNo) {
		return null;
	}

}
