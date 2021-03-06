package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import utility.Connector;

public class MySQLUserDao implements UserDao {

	public void addUser(User userInfo) {

		Connection cn = null;
		PreparedStatement st = null;

		try {
			cn = Connector.getInstance().beginTransaction();
			//

			String sql = "insert into user(user_identified_name,user_name,user_password,user_mail)"
					+ " values(?,?,?,?) ";

			st = cn.prepareStatement(sql);

			// st.setString(1, "U");
			st.setString(1, userInfo.getUserIdentifiedName());
			st.setString(2, userInfo.getUserName());
			st.setString(3, userInfo.getUserPassword());
			st.setString(4, userInfo.getUserMail());
			// st.setInt(6, u.getUserPoint());

			st.executeUpdate();

			Connector.getInstance().commit();

		} catch (SQLException e) {
			Connector.getInstance().rollback();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());

			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
	}

	public User login(String userIdentifiedName, String userMail, String userPassword) {

		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		User u = null;

		try {
			cn = Connector.getInstance().beginTransaction();

			String sql = "select * from user where (user_identified_name='" + userIdentifiedName + "' or user_mail='"
					+ userMail + "') and user_password='" + userPassword + "'" + " and unused = 1";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setUserId(rs.getString(1));
				u.setUserIdentifiedName(rs.getString(2));
				u.setUserName(rs.getString(3));
				u.setUserPassword(rs.getString(4));
				u.setUserMail(rs.getString(5));
				u.setUserPoint(rs.getInt(6));
			}

			Connector.getInstance().commit();

		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
		return u;
	}

	public User getUserInfo(String userId) {

		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		User u = null;

		try {
			cn = Connector.getInstance().beginTransaction();

			String sql = "select * from user where user_id='" + userId + "'";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();
			u = new User();

			rs.next();

			u.setUserId(rs.getString(1));
			u.setUserIdentifiedName(rs.getString(2));
			u.setUserName(rs.getString(3));
			u.setUserPassword(rs.getString(4));
			u.setUserMail(rs.getString(5));
			u.setUserPoint(rs.getInt(6));

			Connector.getInstance().commit();

		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
		return u;
	}

	public void updateUser(String userId, String userName, String userMail) {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = Connector.getInstance().beginTransaction();
			//

			String sql = "update user set user_name='" + userName + "', user_mail='" + userMail + "' where user_id='"
					+ userId + "'";

			st = cn.prepareStatement(sql);

			st.executeUpdate();

			Connector.getInstance().commit();

		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());

			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
	}

	public void removeUser(String userIdentifiedName, String userMail, String userPassword) {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = Connector.getInstance().beginTransaction();
			//

			String sql = "update user set unused=0 where (user_identified_name='" + userIdentifiedName
					+ "' or user_mail='" + userMail + "') and user_password='" + userPassword + "'";

			st = cn.prepareStatement(sql);

			st.executeUpdate();

			Connector.getInstance().commit();

		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());

			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
	}

	public User getUserPassword(String email) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		User u = null;
		try {
			cn = Connector.getInstance().beginTransaction();

			String sql = "select * from user where user_mail='" + email + "'";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setUserId(rs.getString(1));
				u.setUserIdentifiedName(rs.getString(2));
				u.setUserName(rs.getString(3));
				u.setUserPassword(rs.getString(4));
				u.setUserMail(rs.getString(5));
				u.setUserPoint(rs.getInt(6));

			}

			Connector.getInstance().commit();
		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
		return u;
	}

	public User getPoint(String userid) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		User u = null;
		try {
			cn = Connector.getInstance().beginTransaction();

			cn.setAutoCommit(false);

			String sql = "select user_id, user_point from user where user_id='" + userid + "'";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();
			while (rs.next()) {
				u = new User();

				u.setUserId(rs.getString(1));
				u.setUserPoint(rs.getInt(2));
			}
			Connector.getInstance().commit();
		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
		return u;
	}

	public void updatePoint(String userid, String point) {
		Connection cn = null;
		PreparedStatement st = null;
		try {
			cn = Connector.getInstance().beginTransaction();
			//

			String sql = "UPDATE user SET user_point=? WHERE user_id='" + userid + "'";

			st = cn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(point));

			st.executeUpdate();

			Connector.getInstance().commit();

		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());

			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
	}

	// ????????????????????????????????????
	public User getPass(String userid) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		User u = null;
		try {
			cn = Connector.getInstance().beginTransaction();

			cn.setAutoCommit(false);

			String sql = "select user_id, user_password from user where user_id='" + userid + "'";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();
			while (rs.next()) {
				u = new User();

				u.setUserId(rs.getString(1));
				u.setUserPassword(rs.getString(2));
			}
			Connector.getInstance().commit();
		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
		return u;
	}

	public boolean checkEmail(String email) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		boolean f = true;
		try {
			cn = Connector.getInstance().beginTransaction();

			cn.setAutoCommit(false);

			String sql = "select * from user where user_mail='" + email + "'";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();
			while (rs.next()) {
				f = false;

			}
			Connector.getInstance().commit();
		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
		return f;
	}

	public boolean checkIdentifiedName(String identifiedName) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		boolean f = true;
		try {
			cn = Connector.getInstance().beginTransaction();

			cn.setAutoCommit(false);

			String sql = "select * from user where  user_identified_name='" + identifiedName + "'";

			st = cn.prepareStatement(sql);

			rs = st.executeQuery();
			while (rs.next()) {
				f = false;

			}
			Connector.getInstance().commit();
		} catch (SQLException e) {
			Connector.getInstance().rollback();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			} finally {
				if (cn != null) {
					Connector.getInstance().closeConnection();
				}
			}
		}
		return f;
	}

public boolean  confirmLogin(String userIdentifiedName,String userMail,String userPassword){

    Connection cn=null;
    PreparedStatement st=null;
    ResultSet rs=null;

   boolean f=false;

    try{
    	String sql = "select * from user where (user_identified_name='" + userIdentifiedName + "' or user_mail='"
				+ userMail + "') and user_password='" + userPassword + "'" + " and unused = 1";
    	cn = Connector.getInstance().beginTransaction();

        cn.setAutoCommit(false);



        st=cn.prepareStatement(sql);

        rs=st.executeQuery();
        while(rs.next()) {
        	f=true;



        }




    }catch(SQLException e){
        Connector.getInstance().rollback();
        System.out.println(e.getMessage());
    }finally
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		} finally {
			if (cn != null) {
				Connector.getInstance().closeConnection();
			}
		}
	}return f;
}

public boolean  duplicateCheck(String userMail){

    Connection cn=null;
    PreparedStatement st=null;
    ResultSet rs=null;

   boolean check=false;

    try{
    	cn = Connector.getInstance().beginTransaction();

        cn.setAutoCommit(false);

        String sql = "select * from user where user_mail='"+ userMail + "'";

        st=cn.prepareStatement(sql);

        rs=st.executeQuery();

        if(rs.next()) {
        	check = true;
        }




    }catch(SQLException e){
        Connector.getInstance().rollback();
        System.out.println(e.getMessage());
    }finally
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		} finally {
			if (cn != null) {
				Connector.getInstance().closeConnection();
			}
		}
	}return check;
}
}
/*
 * public List getAllUsers(){ Connection cn=null; PreparedStatement st=null;
 * ResultSet rs=null; ArrayList Users=new ArrayList(); try{
 * Class.forName("com.mysql.cj.jdbc.Driver"); cn = DriverManager.getConnection(
 * "jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
 * "booth","pass"); cn.setAutoCommit(false); String sql="select * from user";
 * st=cn.prepareStatement(sql); rs=st.executeQuery(); while(rs.next()){ User
 * u=new User(); u.setUserId(rs.getString(1));
 * u.setUserIdentifiedName(rs.getString(2)); u.setUserName(rs.getString(3));
 * u.setUserPassword(rs.getString(4)); u.setUserMail(rs.getString(5));
 * u.setUserPoint(rs.getInt(6)); Users.add(u); } cn.commit();
 * }catch(ClassNotFoundException e){ System.out.println(e.getMessage());
 * }catch(SQLException e){ try{ cn.rollback(); }catch(SQLException e2){
 * System.out.println(e2.getMessage()); } System.out.println(e.getMessage());
 * }finally{ try{ if(rs !=null){ rs.close(); } if(st !=null){ st.close(); }
 * }catch(SQLException e2){ System.out.println(e2.getMessage()); }finally{ try{
 * if(cn !=null){ cn.close(); } }catch(SQLException e3){
 * System.out.println(e3.getMessage()); } } } return Users; }
 */
//
