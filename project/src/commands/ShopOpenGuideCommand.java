package commands;

import context.ResponseContext;

public class ShopOpenGuideCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("----ShopOpenGuideCommmand----");

		//resc.setResult("おがただにょん");
		resc.setTarget("guide/shop_open");
		return resc;

	}
}
