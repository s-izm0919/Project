package commands;

import context.ResponseContext;

public class ShopCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("shop/open");
		return resc;

	}
}
