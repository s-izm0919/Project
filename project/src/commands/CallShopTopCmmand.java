package commands;

import context.ResponseContext;

public class CallShopTopCmmand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("shop/top");
		return resc;

	}
}
