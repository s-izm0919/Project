package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallIndexCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("index");
		return resc;

	}
}
