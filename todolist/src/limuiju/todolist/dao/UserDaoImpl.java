package limuiju.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import limuiju.todolist.domain.User;

public class UserDaoImpl implements UserDao {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	
	@Override
	public int login(String userId, String userPw) {
		String sql = "select user_pw from users where user_id = ?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userId);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("user_pw").equals(userPw)) {
					result = 1;
				} else result = 2; //비밀번호 틀림
			}
			else result = -1; //아이디 없음
			
			rs.close();
			st.close();
			con.close(); 
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int join(User user) {
		String sql = "insert into users values (?, ?, ?, ?, ?)";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user.getUserId());
			st.setString(2, user.getUserPw());
			st.setString(3, user.getUserEmail());
			st.setString(4, user.getUserEmamilHash());
			st.setString(5, user.getUserEmailChecked());
			
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

	@Override
	public String getUserEmailChecked(String userId) {
		String sql = "select user_emailchecked from users where user_id = ?";
		String result = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userId);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) 
				result = rs.getString("user_emailchecked");
			
			st.close();
			con.close(); 
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int setUserEmailChecked(String userId) {
		String sql = "update users set user_emailchecked = ? where user_id = ?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "true");
			st.setString(2, userId);
			
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

	@Override
	public String getUserEmail(String userId) {
		String sql = "select user_email from users where user_id = ?";
		String result = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userId);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) 
				result = rs.getString("user_email");
			
			st.close();
			con.close(); 
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result.length() > 0) return result;
		else return null;
	}

}
