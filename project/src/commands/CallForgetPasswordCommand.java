package commands;

import context.ResponseContext;

public class CallForgetPasswordCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {


		resc.setTarget("users/reissue");
		return resc;
	}
}

//