package commands;

import context.ResponseContext;

public class CallItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("items/item");
		return resc;

	}

}
