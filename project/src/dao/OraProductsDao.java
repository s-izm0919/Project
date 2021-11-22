package dao;
import bean.Product;

import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import  java.util.ArrayList;
import  java.util.List;

import exp.ResourceAccessException;

public class OraProductsDao implements ProductsDao{

    public void addProduct(Product p){
        Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/nozawa?characterEncoding=UTF-8&serverTimezone=JST",
			"infox","prox");

            cn.setAutoCommit(false);

            String sql="insert into t_products(pid,name,price)"+"values(?,?,?)";

            st=cn.prepareStatement(sql);

            st.setString(1, p.getPid());
            st.setString(2, p.getName());
            st.setString(3, p.getPrice());

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
    public Product getProduct(String pid){
        return null;
    }
    public List getAllProducts(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList products=new ArrayList();
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/nozawa?characterEncoding=UTF-8&serverTimezone=JST",
			"infox","prox");

            cn.setAutoCommit(false);

            String sql="select pid,name,price from t_products";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Product p=new Product();

                p.setPid(rs.getString(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getString(3));

                products.add(p);
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
        return products;
    }
}


