package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import context.RequestContext;

public class SessionManager {
	private static HttpServletRequest req;
	private static HttpSession session;

	private SessionManager(){}

	public static void getSession(RequestContext reqc) {
		req=(HttpServletRequest)reqc.getRequest();
		session=req.getSession();
	}
	public static void setAttribute(String name,Object result){
		session.setAttribute(name,result);
	}
	public static Object getAttribute(String name){
		return session.getAttribute(name);
	}
	public static void invalidate(){
		session.invalidate();
	}
}

