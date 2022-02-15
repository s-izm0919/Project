package utility;

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
		session.setAttribute("token","OK");

	}
	public static void setAttribute(Shop shop) {
		session.setAttribute("shop", shop);
	}


	public static void setAttribute(Object obj) {
		session.setAttribute("object",obj);
	}


	public static void setAttribute(String token) {
		session.setAttribute("token", token);
	}


	public static Object getAttribute(String name){
		return session.getAttribute(name);
	}

	public static void setToken() {
		session.setAttribute("token","OK");
	}

	public static Object getToken() {
		return session.getAttribute("token");
	}

	public static Object getToken(String token) {
		return session.getAttribute("token");
	}
	public static void invalidate(){
		session.invalidate();
	}
}