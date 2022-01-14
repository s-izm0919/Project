package commands;

import context.ResponseContext;

class CallSigninPageCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("top");
		return resc;

	}
}
