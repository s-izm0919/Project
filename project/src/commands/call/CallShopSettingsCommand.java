package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

public class CallShopSettingsCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {


		resc.setTarget("shop/settings");
		return resc;
	}
}
