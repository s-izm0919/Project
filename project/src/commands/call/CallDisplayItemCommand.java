package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

public class CallDisplayItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("shop/items/register/register");
		return resc;

	}
}
