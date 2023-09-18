package edu.web.ajaxquiz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/search.do")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static searchDAO dao;
  
    public searchServlet() {
    	dao= searchDAOImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		//System.out.println("서블릿타이틀 : "+title);
		if(title == null) {
			return;
		}
		ArrayList<String> list = dao.search(title);
		
		JSONObject jsonObject = new JSONObject();
		for(int i =0 ; i<list.size();i++) {
			System.out.println("리스트"+i+" : "+list.get(i));
			jsonObject.put("list"+i, list.get(i));
		}
		response.getWriter().append(jsonObject.toString());
		//System.out.println("제이슨 오브젝트 : "+jsonObject.toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
