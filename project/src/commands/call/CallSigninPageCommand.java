package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallSigninPageCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("top");
		return resc;

	}
}
