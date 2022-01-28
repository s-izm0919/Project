package commands.call;

import javax.servlet.http.HttpServletRequest;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;

public class CallConfirmPasswordCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();

		String shopid = reqc.getParameter("shopId")[0];

		((HttpServletRequest)reqc.getRequest()).setAttribute("shopId",shopid);

		resc.setTarget("orders/confirmpassword");
		return resc;

	}
}