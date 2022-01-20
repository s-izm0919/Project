package commands.item;

import java.util.HashMap;
import java.util.Map;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemSearchDao;

public class CallItemPageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- CallItemPageCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemSearchDao dao = factory.getItemSearchDao();

		RequestContext reqc = getRequestContext();
		String itemId = reqc.getParameter("itemId")[0];

		Map result = new HashMap();

		//ArrayList list = (ArrayList)dao.getItemSearch(itemName);

		result.put("itemsearch", itemId);

		resc.setResult(result);

		resc.setTarget("items/item");

		return resc;

	}
}
