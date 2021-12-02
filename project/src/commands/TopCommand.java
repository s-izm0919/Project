package commands;

import context.ResponseContext;

public class TopCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("top");
		return resc;

	}

}
