package commands;

import context.ResponseContext;

class CallIndexCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("index");
		return resc;

	}
}