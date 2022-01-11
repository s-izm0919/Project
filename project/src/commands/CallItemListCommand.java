package commands;

import java.util.ArrayList;

import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDao;

class CallItemListCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- CallItemListCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemDao dao=factory.getItemDao();

		String itemName = null;

		//ここの表示ができない

		ArrayList list = (ArrayList)dao.getItemsItemName(itemName);

		resc.setResult(list);

		resc.setTarget("items/items");

		return resc;

	}
}