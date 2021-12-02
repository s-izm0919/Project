package commands;

import context.RequestContext;
import context.ResponseContext;
import filter.SessionManager;

public class LogoutUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		SessionManager.getSession(reqc);

		SessionManager.invalidate();

		resc.setTarget("index");

		return resc;
	}
}
