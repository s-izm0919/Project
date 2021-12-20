package dao;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;

import bean.User;

public class MySQLUserDao implements UserDao{

    public void addUser(User userInfo){
        Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://aws-and-infra-web.cmhqjlcrgf5h.ap-northeast-1.rds.amazonaws.com:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            //


            String sql="insert into user(user_identified_name,user_name,user_password,user_mail)" + " values(?,?,?,?) ";

            st=cn.prepareStatement(sql);

           // st.setString(1, "U34");
            st.setString(1, userInfo.getUserIdentifiedName());
            st.setString(2, userInfo.getUserName());
            st.setString(3, userInfo.getUserPassword());
            st.setString(4, userInfo.getUserMail());
            //st.setInt(6, u.getUserPoint());

            st.executeUpdate();

            cn.commit();


        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());

        }catch(SQLException e){
            try{
                cn.rollback();

            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            System.out.println(e.getMessage());

            }
        }
        finally{
            try{
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());

            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
    }
    public User login(String userIdentifiedName,String userMail,String userPassword){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        User u = null;

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://aws-and-infra-web.cmhqjlcrgf5h.ap-northeast-1.rds.amazonaws.com:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="select * from user where (user_identified_name='"+userIdentifiedName+"' or user_mail='"+userMail+"') and user_password='"+userPassword+"'"+" and unused = 1";



            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                u=new User();
	            u.setUserId(rs.getString(1));
	            u.setUserIdentifiedName(rs.getString(2));
	            u.setUserName(rs.getString(3));
	            u.setUserPassword(rs.getString(4));
	            u.setUserMail(rs.getString(5));
	            u.setUserPoint(rs.getInt(6));
            }

            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs !=null){
                    rs.close();
                }
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
        return u;
    }
    public User getUserInfo(String userId){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        User u = null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://aws-and-infra-web.cmhqjlcrgf5h.ap-northeast-1.rds.amazonaws.com:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="select * from user where user_id='"+userId+"'";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            u=new User();

            rs.next();

            u.setUserId(rs.getString(1));
            u.setUserIdentifiedName(rs.getString(2));
            u.setUserName(rs.getString(3));
            u.setUserPassword(rs.getString(4));
            u.setUserMail(rs.getString(5));
            u.setUserPoint(rs.getInt(6));

            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs !=null){
                    rs.close();
                }
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
        return u;
    }

    public void updateUser(String userId,String userName,String userMail) {
    	Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://aws-and-infra-web.cmhqjlcrgf5h.ap-northeast-1.rds.amazonaws.com:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            //

            String sql="update user set user_name='"+userName+"', user_mail='"+userMail+"' where user_id='"+userId+"'";

            st=cn.prepareStatement(sql);

            st.executeUpdate();

            cn.commit();


        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());

        }catch(SQLException e){
            try{
                cn.rollback();

            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            System.out.println(e.getMessage());

            }
        }
        finally{
            try{
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());

            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
    }
    public void removeUser(String userIdentifiedName,String userMail,String userPassword) {
    	Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://aws-and-infra-web.cmhqjlcrgf5h.ap-northeast-1.rds.amazonaws.com:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            //

            String sql="update user set unused=0 where (user_identified_name='"+userIdentifiedName+"' or user_mail='"+userMail+"') and user_password='"+userPassword+"'";

            st=cn.prepareStatement(sql);

            st.executeUpdate();

            cn.commit();


        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());

        }catch(SQLException e){
            try{
                cn.rollback();

            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            System.out.println(e.getMessage());

            }
        }
        finally{
            try{
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());

            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
    }
    public User getUserPassword(String email){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        User u = null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/nozawa?characterEncoding=UTF-8&serverTimezone=JST",
			"infox","prox");

            cn.setAutoCommit(false);

            String sql="select * from user where email='"+email+"'";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();


            while(rs.next()) {
            u=new User();

           // u.setUserId(rs.getString(1));
            u.setUserId(rs.getString(1));
            u.setUserMail(rs.getString(2));
            u.setUserPassword(rs.getString(3));



            }


            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs !=null){
                    rs.close();
                }
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
        return u;
    }

}


    /*
    public List getAllUsers(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Users=new ArrayList();
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="select * from user";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                User u=new User();

                u.setUserId(rs.getString(1));
                u.setUserIdentifiedName(rs.getString(2));
                u.setUserName(rs.getString(3));
                u.setUserPassword(rs.getString(4));
                u.setUserMail(rs.getString(5));
                u.setUserPoint(rs.getInt(6));


                Users.add(u);
            }
            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs !=null){
                    rs.close();
                }
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
        return Users;
    }
    */
//
