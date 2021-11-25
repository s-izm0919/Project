package dao;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.util.ArrayList;
import  java.util.List;


import bean.User;

public class MySQLUserDao implements UserDao{

    public void addUser(User u){
        Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            //

            String sql="insert into user(user_id,user_identified_name,user_name,user_password,user_mail)" + " values(?,?,?,?,?) ";

            st=cn.prepareStatement(sql);

            st.setString(1, "u11");
            st.setString(2, u.getUserIdentifiedName());
            st.setString(3, u.getUserName());
            st.setString(4, u.getUserPassword());
            st.setString(5, u.getUserMail());
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
    public User getUser(String userId){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        User u = null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="select * from user where user_id=userId";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            u=new User();

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
