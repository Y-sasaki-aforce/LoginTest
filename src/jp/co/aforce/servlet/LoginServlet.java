package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.LoginUser;
import jp.co.aforce.dao.SqlDao;

@WebServlet("/jp.co.aforce.servlet/login-servlet")
public class LoginServlet extends HttpServlet {
		//ログイン認証
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン画面で入力された値を取得
		String user = request.getParameter("name");
		String password = request.getParameter("password");

		//インスタンス作成
		SqlDao sql = new SqlDao();
		LoginUser us = new LoginUser();
		try {
			us = sql.search(user, password);
				if(us.getName()!=null && us.getPassword()!=null) {
					request.setAttribute("us", us);
					request.getRequestDispatcher("../jsp/complete.jsp").forward(request, response);
				}else if(us.getName()==null || us.getPassword()==null) {
					request.setAttribute("user", user);
					request.setAttribute("error_msg", "IDまたはパスワードが違います。");
					request.getRequestDispatcher("../jsp/login.jsp").forward(request, response);
				}

		} catch (Exception e) {
			e.printStackTrace();
			}

	}

}