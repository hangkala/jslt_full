/**
 * Copyright(C) 2019 Luvina JSC
 * UserLogic.java, Sep 30, 2019, HangHT
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author HangHT
 *
 */
public class UserLogic extends BaseDatabase {

	public UserLogic() throws ClassNotFoundException {
		super();
	}
	
	public ArrayList<UserBean>getListUser() throws SQLException{
		ArrayList<UserBean>lsUser = new ArrayList<UserBean>();
		StringBuilder sql = new StringBuilder("SELECT * FROM 1user");
		try {
			openConnection();
			if(con == null) {
				return null;
			}
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int index = 0;
				UserBean user = new UserBean();
				user.setId(rs.getInt(++index));
				user.setName(rs.getString(++index));
				user.setBirthday(rs.getDate(++index).toString());
				user.setBirthplace(rs.getString(++index));
				lsUser.add(user);
			}
			return lsUser;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("UserLogic + getListUser + Lỗi cú pháp SQL");
		} finally {
			closeConnection();
		}
	}
	
}
