package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

class CallSigninPageCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("index");
		return resc;

	}
}
