package commands.user;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import utility.SessionManager;

public class LogoutUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		SessionManager.invalidate();

		resc.setTarget("index");

		return resc;
	}
}
