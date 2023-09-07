package edu.web.homework;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 여기서 실행(시작)
@WebServlet("/SendList")
public class SendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SendListServlet() {
        
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// <과제2>
		// * BoardVO 생성(ede.web.homework 패키지에 생성
		// - BoardId(int) , boardTitle(String), userid(String), boardRegDate(Date)
		
		// * SendListServlet.java - doGet()
		// - ArrayList<BoardVO>생성
		// - 게시글 데이터 5개 정도 add
		// forward 방식으로 HW2.jsp 파일에 list 데이터 전송
		
		
		// HW2.jsp(homework/HW2.jsp)경로가 다르다
		// - SendListServlet.java 에서 전송된 list 데이터 저장
		// - 저장된 list 데이터 테이블 형태로 출력
		
		// * BoardVO, senListServlet.java, HW2.jsp 파일
		// [본인 이름_HW2].zip 으로 압축해서 제출
		
		Date today = new Date();
		
		
		BoardVO vo = new BoardVO(1001, "게시판 공지", "admin", today);
		BoardVO vo2 = new BoardVO(1002, "게시물 1", "kim", today);
		BoardVO vo3 = new BoardVO(1003, "게시물 2", "ral", today);
		BoardVO vo4 = new BoardVO(1004, "게시물 3", "ho", today);
		BoardVO vo5 = new BoardVO(1005, "게시물 4", "jeon", today);
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		list.add(vo);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		
		request.setAttribute("list", list);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/homework/HW2.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
