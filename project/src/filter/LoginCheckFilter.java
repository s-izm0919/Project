package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import context.ResponseContext;

import bean.Shop;
import bean.User;
import dao.AbstractDaoFactory;
import dao.ShopDao;
import dao.UserDao;


public class LoginCheckFilter implements Filter {
    private FilterConfig config;


    public void init(FilterConfig config) throws ServletException{
        this.config=config;
    }
    public void destroy(){

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException{


ResponseContext resc=null;
Map result=new HashMap();
    	String mail=null;
		String userIdentifiedName=null;

		String userIdenNameOrEmail=null;

		userIdenNameOrEmail=req.getParameter("userIdenNameOrEmail");

		if(userIdenNameOrEmail != null){
			if(userIdenNameOrEmail.contains("@")) {
				mail=userIdenNameOrEmail;
			}else {
				userIdentifiedName=userIdenNameOrEmail;

			}

			String password=req.getParameter("userPassword");

			System.out.println("----loginCheckFilter------");
			System.out.println("identifidname: " + userIdentifiedName);
			System.out.println("password: " + password);
			System.out.println("email: " + mail);




			User user=null;

			HttpSession session = ((HttpServletRequest)req).getSession();

			AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
			UserDao dao=factory.getUserDao();
			boolean checkLogin=dao.confirmLogin(userIdentifiedName, mail, password);
			if(userIdentifiedName!=null&&mail==null) {
				if(checkLogin==false) {
					 System.out.println(" id or password not matched");
					// req.setAttribute("result","IDまたはパスワードが違います	");
					// RequestDispatcher dispatcher=req.getRequestDispatcher("jsp/users/sign_in.jsp");
					 //RequestDispatcher dispatcher=req.getRequestDispatcher("callsignin");
					// dispatcher.forward(req, res);
					session.setAttribute("mess", "IDまたはパスワードが違います");

					 //result.put("mess","IDまたはパスワードが違います" );
					// resc.setResult(result);
					// resc.setTarget("users/sign_in");





				}
				// user=dao.login(userIdentifiedName,null,password);
				System.out.println("user:"+user.getUserName());
			}else if(userIdentifiedName==null&&mail!=null) {
				if(checkLogin==false) {
					 System.out.println(" mail or password not matched");

					 //result.put("mess","メアドまたはパスワードが違います" );
					// resc.setResult(result);
					// resc.setTarget("users/sign_in");

					 //req.setAttribute("result","メアドまたはパスワードが違います	");
					// RequestDispatcher dispatcher=req.getRequestDispatcher("callsignin");
					 //dispatcher.forward(req, res);


						session.setAttribute("mess", "メアドまたはパスワードが違います");
				}
				else
				 user=dao.login(null,mail,password);
				//System.out.println("user:"+user.getUserName());
			}

			/*if(user==null) {
				 System.out.println(" mail or password not matched");
				 result.put("mess", "メアドまたはパスワードが違います");
				 resc.setResult("result");
					resc.setTarget("users/sign_in");*/



			if(user!=null) {

				session.setAttribute("token","OK");
				session.setAttribute("user", user);
				String userId=user.getUserId();
				ShopDao shopDao=factory.getShopDao();
				Shop shopInfo=shopDao.getUserShopInfo(userId);
				System.out.println("shopinfo:"+shopInfo);
				if(shopInfo!=null) {
					session.setAttribute("shop", shopInfo);

				}
				else {
					shopInfo = new Shop();
					session.setAttribute("shop", shopInfo);
				}


			}

			//System.out.println("start shop session");




		}


        chain.doFilter(req,res);


    }
}
