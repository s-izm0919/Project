package commands;

import context.ResponseContext;

public class SearchTestCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("search");
		return resc;


	}

}

