package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {

	public  boolean  sub (String logincd, String loginpw){
		// TODO 自動生成されたメソッド・スタブ
		// a例外あり
		try {
			// JDBCドライバ(MYSQL用)を登録する
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBCドライバの登録終了");
		} catch (ClassNotFoundException ex) {
			// 例外処理
			ex.printStackTrace();
		}

		// DBに接続するために必要な情報を変数定義している。
		// 接続する場所を定義（URLとして)
		boolean flg =false;
		String url = "jdbc:mysql://localhost/ec";
		// 接続する際のIDを定義
		String id = "root";
		// 接続する際のパスワードを定義
		String pass = "password";

		// DBにアクセスする、した際に必要な部品を定義
		// DBに接続する際に使用する部品。(接続失敗時にSQLExceptionを投げる）
		Connection conn = null;
		// SQLを実行する際に使う部品。
		Statement stmt = null;
		// SQLの実行結果を格納する箱
		ResultSet rs = null;







		try {



			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("DBMSとの接続完了");

			// 接続に成功した場合は、stmtに接続情報を設定する。
			stmt = conn.createStatement();


			String sql = "SELECT * FROM user WHERE login_cd='" + logincd + "'AND login_pw='" + loginpw+"'" ;

			//a変数sqlに入ってるsql文を実行し、rs(ResultSet)に格納している。
			rs  = stmt.executeQuery(sql);

			if(rs.next()) {
				flg = true;
			}





		} catch (SQLException ex) {
			ex.printStackTrace();
			// finallyはエラーの発生有無にかかわらず実行される。
		}

		try {
			String category = "SELECT * from category";


		} finally {
			try {
				// 各部品はDBの処理が終わったら閉じなければならない。
				// 閉じる順番も大切!!
				// rsをcloseする。
				if (rs != null)
					rs.close();
				// stmtをcloseする。
				if (stmt != null)
					stmt.close();
				// connをcloseする。
				if (conn != null)
					conn.close();
				return flg;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return flg;
	}

	public  ArrayList<String>  cada (){
		// TODO 自動生成されたメソッド・スタブ


		// DBに接続するために必要な情報を変数定義している。
		// 接続する場所を定義（URLとして)

		String url = "jdbc:mysql://localhost/ec";
		// 接続する際のIDを定義
		String id = "root";
		// 接続する際のパスワードを定義
		String pass = "password";

		// DBにアクセスする、した際に必要な部品を定義
		// DBに接続する際に使用する部品。(接続失敗時にSQLExceptionを投げる）
		Connection conn = null;
		// SQLを実行する際に使う部品。
		Statement stmt = null;
		// SQLの実行結果を格納する箱
		ResultSet rs = null;

			String category1;
		ArrayList<String> list = new ArrayList<String>();

		try {



			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("DBMSとの接続完了");

			// 接続に成功した場合は、stmtに接続情報を設定する。
			stmt = conn.createStatement();


			String sql = "SELECT * FROM category" ;

			//a変数sqlに入ってるsql文を実行し、rs(ResultSet)に格納している。
			rs  = stmt.executeQuery(sql);

			while(rs.next()) {
			 category1 = rs.getString("cat_name");
			 System.out.println(category1);


				 list.add(category1);

			}
			return list;

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				// 各部品はDBの処理が終わったら閉じなければならない。
				// 閉じる順番も大切!!
				// rsをcloseする。
				if (rs != null)
					rs.close();
				// stmtをcloseする。
				if (stmt != null)
					stmt.close();
				// connをcloseする。
				if (conn != null)
					conn.close();
				return list;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}
}