package context;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebRequestContext implements RequestContext {
	private Map parameters;
	private HttpServletRequest request;
	private HttpSession session;
	public WebRequestContext() {}

	public String getCommandPath() {
		//	サーブレットパスを取得する
		String servletPath = request.getServletPath();
		String commandPath = servletPath.substring(1);
		return commandPath;
	}

	public String[] getParameter(String key) {
		return (String[]) parameters.get(key);
	}

	public Object getRequest() {
		return request;
	}

	@Override
	public void setRequest(Object req) {
		request = (HttpServletRequest) req;
		parameters = request.getParameterMap();
		session = (HttpSession)request.getSession();
	}

	public Object getSessionAttribute(String name) {
		return session.getAttribute(name);
	}


	public void setSession(Object obj) {
		session.setAttribute("result", obj);
	}


}
