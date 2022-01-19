package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallSigninCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("users/sign_in");
		return resc;

	}
}

