package context;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import utility.SessionManager;

public class WebRequestContext implements RequestContext {
	private Map parameters;
	private HttpServletRequest request;
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
		utility.SessionManager.getSession(request);
	}
}
