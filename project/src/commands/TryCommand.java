package commands;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Item;
import context.ResponseContext;

class TryCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

	HashMap result = new HashMap();

	Item item = new Item();
	item.setItemName("サンプル");
	item.setItemPrice(200);

	ArrayList list = new ArrayList();
	list.add(new String("A"));
	list.add(new String("B"));
	list.add(new String("C"));

	result.put("item", item);
	result.put("list", list);

	resc.setResult(result);

	resc.setTarget("index");
		return resc;

	}
}