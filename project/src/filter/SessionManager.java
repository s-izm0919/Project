package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Shop;
import bean.User;


public class SessionManager {
	private static HttpServletRequest req;
	private static HttpSession session;

	private SessionManager(){}

	public static void getSession(HttpServletRequest request) {
		req=request;
		session=req.getSession();
	}
	public static void setAttribute(User user){
		session.setAttribute("user",user);
	}
	public static void setAttribute(Shop shop) {
		session.setAttribute("shop", shop);
	}

	public static Object getAttribute(String name){
		return session.getAttribute(name);
	}

	public static void invalidate(){
		session.invalidate();
	}
}