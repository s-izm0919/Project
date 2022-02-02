package commands.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemSearchDao;

public class SearchItemCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- SearchItemCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemSearchDao dao = factory.getItemSearchDao();

		RequestContext reqc = getRequestContext();
		String itemName = reqc.getParameter("itemName")[0];

		if(itemName=="") {
			itemName=null;
		}

		Map result = new HashMap();

		ArrayList list = (ArrayList)dao.getItemSearch(itemName);

		result.put("itemsearch", list);

		int itemcount = list.size();
		System.out.println(itemcount+"件ヒット");

		result.put("itemcount", itemcount);
		result.put("searchword", itemName);

		resc.setResult(result);

		resc.setTarget("search");

		return resc;

	}
}
