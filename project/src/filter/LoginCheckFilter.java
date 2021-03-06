package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
			if(userIdentifiedName!=null&&mail==null) {
				user=dao.login(userIdentifiedName,null,password);
				//System.out.println("user:"+user.getUserName());
			}else if(userIdentifiedName==null&&mail!=null) {
				user=dao.login(null,mail,password);
				//System.out.println("user:"+user.getUserName());
			}
			else {
				System.out.println("loginできない");
			}

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