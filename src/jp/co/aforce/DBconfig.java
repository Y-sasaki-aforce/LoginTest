package jp.co.aforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBconfig {
	public String[] getDBinfo(String path) throws FileNotFoundException {

		Properties  info = new Properties();
		FileInputStream file_stream = null;

		try {

			file_stream = new FileInputStream(path);
			info.load(file_stream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//DBconfigのキーから値を取得する
		String url = info.getProperty("url");
		String user = info.getProperty("user");
		String password = info.getProperty("password");

		//DBconfigの値を配列に格納しておく
		String[] db_info = {url,user,password};

		//『接続情報、ユーザ名、パスワード』の情報を返す
		return db_info;
	}
}
