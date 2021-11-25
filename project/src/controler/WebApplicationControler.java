package controler;

import java.io.IOException;
import context.RequestContext;
import context.*;
import commands.AbstractCommand;
import commands.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebApplicationControler implements ApplicationControler {
	public RequestContext getRequest(Object request) {
		RequestContext reqc=new WebRequestContext();
		reqc.setRequest(request);
		return reqc;
	}
	public ResponseContext handleRequest (RequestContext reqc) {
		AbstractCommand command=CommandFactory.getCommand(reqc);
		command.init(reqc);
		ResponseContext resc=command.execute(new WebResponseContext());
		return resc;
	}
	public void handleResponse(RequestContext reqc,ResponseContext resc) {
		HttpServletRequest req=(HttpServletRequest)reqc.getRequest();
		HttpServletResponse res=(HttpServletResponse)resc.getResponse();
		req.setAttribute("result", resc.getResult());

		System.out.println("取得結果： " + resc.getResult());
		System.out.println("転送先 : " + resc.getTarget());

		RequestDispatcher rd=req.getRequestDispatcher(resc.getTarget());
		try {
			rd.forward(req, res);
		} catch(ServletException e) {
		} catch (IOException e) {

		}


	}


}
