package commands;

import context.ResponseContext;

public class CallForgotPasswordCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {


		resc.setTarget("users/reissue");
		return resc;
	}
}

//