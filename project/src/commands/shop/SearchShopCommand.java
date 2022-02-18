package commands.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemSearchDao;

public class SearchShopCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- SearchShopCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemSearchDao dao = factory.getItemSearchDao();

		RequestContext reqc = getRequestContext();
		String shopName = reqc.getParameter("shopName")[0];

		if(shopName=="") {
			shopName=null;
		}

		Map result = new HashMap();

		ArrayList list = (ArrayList)dao.getShopSearch(shopName);

		result.put("itemsearch", list);

		int itemcount = list.size();

		if(itemcount == 0) {
			itemcount = 0;
		}

		result.put("itemcount", itemcount);

		result.put("shopsearchword", shopName);
		result.put("itemsearchword", new String(""));

		resc.setResult(result);

		resc.setTarget("search");

		return resc;

	}
}
