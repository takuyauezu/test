package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {


		try {

			//JDBCドライバ(MYSQL)を登録する
			Class.forName("com.mysql.jdbc.Driver");

			} catch (ClassNotFoundException ex) {

				//例外処理
			ex.printStackTrace();
		// TODO 自動生成されたメソッド・スタブ



	}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String url = "jdbc:mysql://localhost/ec";
			String id = "root";
			String pass = "password";

			//引数(url,id.pass)を元にDBに接続している
//			connの代入結果は、接続が成功したか失敗したかの結果
			conn = DriverManager.getConnection(url,id,pass);
			stmt = conn.createStatement();

			String query = "SELECT * FROM product";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String msg = rs.getString("pro_msg");
				String name = rs.getString("pro_name");
				String no = rs.getString("pro_no");
				String price = rs.getString("pro_price");
				String id1 = rs.getString("pro_id");
				String img = rs.getString("pro_img");
				String cd = rs.getString("pro_cd");
				System.out.println(msg + " " + name);


			String as = "SELECT * FROM category";
			rs = stmt.executeQuery(as);
			while(rs.next()) {
				String cat_id = rs.getString("cat_id");
				String cat_name = rs.getString("cat_name");
				System.out.println(cat_id + ""+ cat_name);
			}

			
			
			}

			} catch (SQLException ex) {
			ex.printStackTrace();
			}finally {
				try {
					if (rs !=null)rs.close();
					if (stmt!=null) stmt.close();
					if (conn!=null) conn.close();
				}catch(Exception ex) {
					ex.printStackTrace();

				}
			}
	}
}
