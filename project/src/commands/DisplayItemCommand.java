package commands;

import context.ResponseContext;

public class DisplayItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("shop/items/register/register");
		return resc;

	}
}
