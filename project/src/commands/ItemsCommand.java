package commands;

import context.ResponseContext;

public class ItemsCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		resc.setResult("おがただにょん");
		resc.setTarget("items/items");
		return resc;

	}}
