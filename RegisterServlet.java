package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : member-register.jsp에서 전송받은 데이터를 DB에 저장
// 		  DB 저장 후에 login.jsp로 이동(심심하면 alert도 띄우기)

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDAO dao;

    public RegisterServlet() {
    	dao = MemberDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Homepage_JH/member-register.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo = new MemberVO(memberId, password, email, emailAgree, interest, phone, introduce);
	
		int result = dao.insert(vo);
//		System.out.println(result+"행 삽입!");
		if(result==1) {
//			response.sendRedirect("Homepage_JH/login.jsp"); // 리다이렉트를 쓰면 모든 request,response 값을 없애고 보낸다
//			System.out.println("register실행 확인");
//			response.setCharacterEncoding("UTF-8"); // web.xml에 설정해두면 이것도 안해도된다.
			
			out.append("<!DOCTYPE HTML><head><meta charset='UTF-8'><script>alert('회원등록에 성공했습니다!'); location.href='login.jsp'</script></head></html>");
//			response.sendRedirect("login.jsp");
		}
	}

}
