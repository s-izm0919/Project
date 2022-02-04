package commands.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.SearchDetail;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemSearchDao;


public class SearchItemDetailCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

	System.out.println("-- SearchItemDetailCommand -- ");

	AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
	ItemSearchDao dao = factory.getItemSearchDao();

	RequestContext reqc = getRequestContext();

	String searchWord = reqc.getParameter("searchword")[0];
	String sort = reqc.getParameter("sort")[0];
	String selectCategory = reqc.getParameter("category")[0];
	String maxPrice = reqc.getParameter("maxprice")[0];

	if(sort == "") {
		sort = "0";
	}
	if(selectCategory =="") {
		selectCategory = "0";
	}

	int price = Integer.parseInt(maxPrice);


	if(price >= 4900) {
		price = 42949672;
	}
	System.out.println(price);
	System.out.println(searchWord);
	System.out.println(sort);

	SearchDetail searchDetail = new SearchDetail();

	searchDetail.setSearchWord(searchWord);
	searchDetail.setSort(Integer.parseInt(sort));
	searchDetail.setSelectCategory(Integer.parseInt(selectCategory));
	searchDetail.setMaxPrice(price);

	ArrayList itemlist = (ArrayList)dao.getItemSearchDetail(searchDetail);

	Map result = new HashMap();

	result.put("itemsearch",itemlist);
	result.put("searchword",searchWord);

	resc.setResult(result);

	resc.setTarget("search");

	return resc;
	}
}
