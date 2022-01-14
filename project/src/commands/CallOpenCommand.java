package commands;

import context.ResponseContext;

class CallOpenCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("shop/open");
		return resc;

	}
}

