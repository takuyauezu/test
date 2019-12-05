package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

    /*public LoginServlet() {

    }*/

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		// super.doPost(req, resp);

		req.setCharacterEncoding("UTF-8");


		String login_cd =req.getParameter("login_cd");
		String login_pw =req.getParameter("login_pw");

		System.out.println(login_cd);
		System.out.println(login_pw);
		//aもし、ログインコードが空白または、ログインコードがnullのとき、または、ログインパスワードが空白のとき、または、ログインコードがnullのとき。
		if((login_cd.equals("") || login_cd == null)||
				login_pw.equals("") || login_pw == null) {
			System.out.println("入力せい！");
			//aリクエストディスパッチャーで未入力時の画面に飛ぶ
			RequestDispatcher rd = req.getRequestDispatcher("jsp/LoginError1.jsp");
			rd.forward(req,resp);
			return;
		}

		JDBC jb = new JDBC();

		boolean login;


		login = jb.sub(login_cd,login_pw);

		//if文でtrueであれば、searchに飛べばいい。
		//true以外の場合は


		if(login == true) {
			ArrayList<String> list = new ArrayList<String>();
			req.setAttribute(list);








			RequestDispatcher rd = req.getRequestDispatcher("jsp/search.jsp");
			rd.forward(req,resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("jsp/LoginError2.jsp");
			rd.forward(req,resp);
		}
	}
}