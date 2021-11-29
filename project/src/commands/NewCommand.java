package commands;

import context.ResponseContext;

class NewCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setResult("おがただにょん");
		resc.setTarget("users/new");
		return resc;

	}
}
