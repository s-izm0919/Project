package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

public class CallUserSettingsCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("users/settings");
			return resc;

		}
}