package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

public class CallDepositeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

	System.out.println("-- CallDepositeCommand -- ");

	resc.setTarget("users/deposite");

	return resc;
	}
}
