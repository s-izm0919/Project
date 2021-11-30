package commands;

import context.ResponseContext;

class CallSigninCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("users/sign_in");
		return resc;

	}
}

