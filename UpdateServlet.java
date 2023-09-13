package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : member-update.jsp에서 전송받은 데이터를 DB 회원 정보 수정
// 			회원 정보 수정에 성공하면 member-result.jsp에 vo 데이터 전송하여 출력
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;
    
    public UpdateServlet() {
    	dao=MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone  = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
		

		MemberVO vo = new MemberVO(memberId, password, email, emailAgree, interest, phone, introduce);
		
		int result= dao.update(vo);
		
		if(result==1) {
			request.setAttribute("vo", vo);
			ServletContext context = getServletContext();
//			out.append("<!DOCTYPE HTML><head><meta charset='UTF-8'><script>alert('성공적으로 수정 되었습니다.');</script></head></html>");
//			out.close();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/member-result.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
