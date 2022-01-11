package commands;

import java.util.ArrayList;

import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDao;

public class SearchItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- SearchItemCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemDao dao=factory.getItemDao();

		RequestContext reqc = getRequestContext();
		String itemName = reqc.getParameter("itemName")[0];

		if(itemName=="") {
			itemName=null;
		}

		ArrayList list = (ArrayList)dao.getItemsItemName(itemName);

		resc.setResult(list);

		resc.setTarget("items/items");

		return resc;

	}
}
