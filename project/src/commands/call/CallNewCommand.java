package commands.call;

import commands.AbstractCommand;
import context.ResponseContext;

 public class CallNewCommand extends AbstractCommand {
	//@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		//resc.setResult("おがただにょん");
		resc.setTarget("users/new");
		return resc;

	}
	
}
