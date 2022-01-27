package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallShopItemDetailsCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("---CallShopitemDetailscommand---");

	resc.setTarget("shop/items/shopitemdetails");
		return resc;

	}
}



