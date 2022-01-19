package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallShopInfoCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("shop/shopinfo");
		return resc;

	}
}


