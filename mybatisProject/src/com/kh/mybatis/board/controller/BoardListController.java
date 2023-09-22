package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -----------페이징 처리-------------
		// 핵어려움 주의 + 원리를 파악하자 => 결국은 공식을 외우면됨
				
		int listCount = new BoardServiceImpl().selectListCount(); 			// 현재 총 게시글 개수
		int currentPage = Integer.parseInt(request.getParameter("cpage")); 	// 현재 페이지 (즉, 사용자가 요청한 페이지)
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5); // 누워있으면 static 메모리
		
		ArrayList<Board> list = new BoardServiceImpl().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
	
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
