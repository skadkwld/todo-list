package limuiju.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import limuiju.todolist.domain.Done;
import limuiju.todolist.domain.Todo;

public class DoneDaoImpl implements DoneDao {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	
	@Override
	public List<Done> selectDoneList() {
		String sql = "select * from dones order by done_date";
		
		List<Done> doneList = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Done done =new Done();
				done.setDoneNum(rs.getInt("done_num"));
				done.setTitle(rs.getString("title"));
				done.setDoneDate(rs.getDate("done_date"));
				done.setUserId(rs.getString("user_id"));
				doneList.add(done);
			}
				
				rs.close();
				st.close();
				con.close();
				
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doneList;
	}
	
	@Override
	public int insertDone(String userId, String doneDate, String title) {
		int result = 0;
		String sql 
		= "insert into dones(user_id, done_date, title) "
				+ "values (?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userId);
			st.setString(2, doneDate);
			st.setString(3, title);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
				
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
