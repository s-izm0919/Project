package commands.call;

import java.util.ArrayList;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemSearchDao;

class CallItemListCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- CallItemListCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemSearchDao dao = factory.getItemSearchDao();

		RequestContext reqc = getRequestContext();
		String itemName = reqc.getParameter("itemName")[0];

		if(itemName=="") {
			itemName=null;
		}

		ArrayList list = (ArrayList)dao.getItemSearch(itemName);

		resc.setResult(list);

		resc.setTarget("items/items");

		return resc;

	}
}