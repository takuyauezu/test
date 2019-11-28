package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sample1JDBC {

	public static void main(String[] args)throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost/ec";
		String id = "root";
		String pass = "password";

		String sql = "SELECT * FROM product WHERE cat_id = 1";
		
	

		 try{
	            //JDBCドライバをロードする
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            //DBへのコネクションを作成する
	            conn = DriverManager.getConnection(url, id, pass);


	            ps = conn.prepareStatement(sql);

	            //SELECTを実行する
	            rs = ps.executeQuery();

	            //取得した結果を全件出力する
	            while(rs.next()){
	                System.out.print(rs.getInt("NO"));
	                System.out.print("/" + rs.getString("NAME"));
	                System.out.print("/" + rs.getString("ADDRESS"));
	                System.out.print("/" + rs.getString("TEL"));
	                System.out.println();
	            }

	        }catch(Exception ex){
	            //例外発生時の処理
	            ex.printStackTrace();  //エラー内容をコンソールに出力する

	        }finally{
	            //クローズ処理
	            if(rs != null) rs.close();
	            if(ps != null) ps.close();
	            if(conn != null) conn.close();
	        }

	    }

}