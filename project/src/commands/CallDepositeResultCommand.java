package commands;

import context.ResponseContext;

public class CallDepositeResultCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("users/deposit_verification");
		return resc;

	}
}
