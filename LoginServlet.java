package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * TODO : login.jsp에서 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서
 * 			데이터가 일치하면 - 로그인 성공(login-result.jsp)로 이동 및 로그인 세션 생성 
 * 			(아이디 값에 대한 세션 생성. 세션 만료 시간 60초)
 * 			데이터가 일치하지 않으면 - login.jsp로 이동(심심하면 실패 alert 띄우기)
 */
import javax.servlet.http.HttpSession;

@WebServlet("/login_auth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

	public LoginServlet() {
		dao = MemberDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.sendRedirect("login.jsp");
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE HTML>").append("<head><meta charset='UTF-8'></head>").append("<body>").append("<script>")
		.append("alert('잘못된 경로입니다.');").append("location.href='login.jsp'</script>").append("</body>").append("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
//		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
//		System.out.println("id : " + memberId + password);

		MemberVO memberInfo = dao.select(memberId);
		
		if (memberInfo !=null && password.equals(memberInfo.getPassword())) {
//			System.out.println("로그인성공?" + memberInfo.toString());
		
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(60);
				session.setAttribute("memberId", memberId);
				response.sendRedirect("login-result.jsp");
		
		}else{
//			System.out.println("실행?");
			
			out.append("<!DOCTYPE HTML>").append("<head><meta charset='UTF-8'></head>").append("<body>").append("<script>")
			.append("alert('아이디 혹은 비밀번호가 틀렸습니다!');").append("location.href='login.jsp'</script>").append("</body>").append("</html>");
			out.close();
//			response.sendRedirect("login.jsp"); alert창을 띄우면 sendRedirect가 불가능해짐
			
		}

	}

}
