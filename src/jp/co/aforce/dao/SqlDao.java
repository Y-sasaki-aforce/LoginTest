package jp.co.aforce.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.LoginUser;

public class SqlDao extends Dao{

	public LoginUser search(String name, String password) throws Exception{

		Connection conn = getConnection();

		String sql = "select * from login where name = ? and password = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			//変数sqlの一番目の?に引数のuserをセットする
			stmt.setString(1, name);
			//変数sqlの二番目の?に引数のpasswordをセットする
			stmt.setString(2, password);
			//sqlを実行し該当するデータ格納
			ResultSet rs = stmt.executeQuery();

			LoginUser  us = new LoginUser();

			while(rs.next()) {
				us.setName(rs.getString("name"));
				us.setPassword(rs.getString("password"));
			}
			stmt.close();
			conn.close();

		return us;
	}
}