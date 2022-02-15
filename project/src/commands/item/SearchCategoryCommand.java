package commands.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemSearchDao;

public class SearchCategoryCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- SearchItemCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemSearchDao dao = factory.getItemSearchDao();

		RequestContext reqc = getRequestContext();
		String categoryId = reqc.getParameter("categoryId")[0];

		Map result = new HashMap();

		ArrayList list = (ArrayList)dao.getCategorySearch(Integer.parseInt(categoryId));

		result.put("itemsearch", list);

		int itemcount = list.size();
		if(itemcount == 0){
			itemcount = 0;
		}
		System.out.println(itemcount+"件ヒット");

		result.put("itemcount", itemcount);

		resc.setResult(result);

		resc.setTarget("search");

		return resc;

	}
}
