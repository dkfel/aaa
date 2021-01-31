package hw.q1.kji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyCreate {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		String sql = null;
		PreparedStatement ptmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connection 성공");
			
			sql = "create table company(" + 
					" cno number constraint company_cno_p primary key," + 
					" cname varchar2(30) constraint company_cname_n not null," + 
					" ceo varchar2(30)," + 
					" tel varchar2(20)," + 
					" dam varchar2(30)" + 
					")";
			ptmt = conn.prepareStatement(sql);
			ptmt.executeUpdate();
				
			ptmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
