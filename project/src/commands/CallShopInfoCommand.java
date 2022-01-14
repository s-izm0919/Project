
package commands;

import context.ResponseContext;

class CallShopInfoCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	resc.setTarget("shop/shopinfo");
		return resc;

	}
}
