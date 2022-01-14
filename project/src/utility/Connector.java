package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector{

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "infox";
	private static String pass = "prox";
	private static String url = "jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST";
	//AWSに移行する際に接続記述子を変える。githubに公開するときは危険なので書かないこと

	private static Connector connector = null;
	private static Connection cn = null;

	private Connector() {}


	public static Connector getInstance(){
	  if(connector == null){
	    connector = new Connector();
	  }

	  return connector;
	}

	private Connection getConnection(){
		try {
			Class.forName(driver);

			cn = DriverManager.getConnection(url,user,pass);

			cn.setAutoCommit(false);

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

	public void closeConnection(){
		System.out.println("---connectorection---");
		    try{
		      if(cn != null){
		        //Connectionのインスタンスの破棄ができてないっぽい

		    	  System.out.println("close");
		        cn.close();
		        cn=null;
		      }
		    }catch(SQLException e){
		      e.printStackTrace();
		      System.out.println("closeできませんでした。SQL関連の例外です");
		    }
		  }

	public Connection beginTransaction(){
	    if(cn ==null){
	    	try {
	    		cn = getConnection();
	    	}catch(Exception e) {

	    	}
	    }
	    try{
	      cn.setAutoCommit(false);
	    }catch(SQLException e){
	      e.printStackTrace();
	      System.out.println("setAutoCommitできませんでした。SQL関連の例外です");
	    }
	    return cn;
	  }

	  public void commit(){
	    try{
	      cn.commit();
	    }catch(SQLException e){
	      e.printStackTrace();
	      System.out.println("commitできませんでした。SQL関連の例外です");
	    }
	  }

	  public void rollback(){
	    try{
	      cn.rollback();
	    }catch(SQLException e){
	      e.printStackTrace();
	      System.out.println("rollbackできませんでした。SQL関連の例外です");
	    }
	  }
}