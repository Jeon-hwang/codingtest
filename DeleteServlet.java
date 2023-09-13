package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : member-result.jsp에서 이동
//			session에서 userid값을 저장하여 DB 회원 정보 삭제
//			삭제 성공 후에 login.jsp 이동
@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;  
	
    public DeleteServlet() {
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		response.setCharacterEncoding("UTF-8");// printWriter 선언전에 인코딩을 해야한다
		PrintWriter out = response.getWriter();
		String memberId = (String) session.getAttribute("memberId");
		
		int result = dao.delete(memberId);
//		System.out.println("삭제가 실행 되었나?"+result);
		if(result==1) {
			session.setMaxInactiveInterval(0);
			out.append("<!DOCTYPE HTML>").append("<head><meta charset='UTF-8'></head>").append("<body>").append("<script>")
			.append("alert('탈퇴하였습니다.');").append("location.href='login.jsp'</script>").append("</body>").append("</html>");
			out.close();
//			response.sendRedirect("login.jsp");
		}
//		System.out.println("이것이 실행 안된건가");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
