package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallEditItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("---CallShopitemDetailscommand---");

	resc.setTarget("shop/items/edit/edit");
		return resc;

	}
}




