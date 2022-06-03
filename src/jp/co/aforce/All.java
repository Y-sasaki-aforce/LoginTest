package jp.co.aforce;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.aforce.tool.Page;


@WebServlet(urlPatterns = {"/jp.co.aforce/all"})
public class All extends HttpServlet {

	public void doGet(
		//リクエストを取得するために使う引数、レスポンスを生成するために使う引数
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		//文字エンコーディングの指定をする
		response.setContentType("text/html; charset=UTF-8");
		//HttpServletResponseインターフェイスのgetWriterメソッドを使い、レスポンスを生成する
		//PrintWriterオブジェクトを変数に取得する←レスポンスを出力する
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			//データソースを取得するためにInitialContextオブジェクトを生成する
			InitialContext ic=new InitialContext();
			//context.xmlのname属性に指定したデータソース名を指定
			DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/login_db");
			//Connectionオブジェクトを取得
			Connection con=ds.getConnection();

			/*引数にSQL文を指定してexecuteQueryメソッドで実行し、
			  ResultSetオブジェクトに表形式で結果が返ってくる*/
			PreparedStatement st=con.prepareStatement(
					"select * from login");
			ResultSet rs=st.executeQuery();

			//nextメソッドはテーブルのレコードを上から順々にデータを取得する
			//取得した分だけ繰り返し処理
			while(rs.next()) {
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println(":");
				out.println(rs.getInt("password"));
				out.println("<br>");
			}
			//ResultSetはprepareStatementをクローズすれば自動的にクローズされる
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
