package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallOpenCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("shop/open");
		return resc;

	}
}

