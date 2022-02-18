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


	String sort = reqc.getParameter("sort")[0];
	String selectCategory = reqc.getParameter("category")[0];
	String maxPrice = reqc.getParameter("maxprice")[0];

	String searchWord;
	ArrayList itemlist;

	Map result = new HashMap();

	if(reqc.getParameter("itemsearchword")[0]!="") {
		System.out.println("アイテム検索");

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

		SearchDetail searchDetail = new SearchDetail();

		searchDetail.setSearchWord(reqc.getParameter("itemsearchword")[0]);
		searchDetail.setSort(Integer.parseInt(sort));
		searchDetail.setSelectCategory(Integer.parseInt(selectCategory));
		searchDetail.setMaxPrice(price);

		itemlist = (ArrayList)dao.getItemSearchDetail(searchDetail);

		result.put("itemsearchword",reqc.getParameter("itemsearchword")[0]);
		result.put("shopsearchword",new String(""));
	}else {
		System.out.println("ショップ検索");
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

		SearchDetail searchDetail = new SearchDetail();

		searchDetail.setSearchWord(reqc.getParameter("shopsearchword")[0]);
		searchDetail.setSort(Integer.parseInt(sort));
		searchDetail.setSelectCategory(Integer.parseInt(selectCategory));
		searchDetail.setMaxPrice(price);

		itemlist = (ArrayList)dao.getShopSearchDetail(searchDetail);

		result.put("itemsearchword", new String(""));
		result.put("shopsearchword", reqc.getParameter("shopsearchword")[0]);
	}

	Integer itemcount=0;

	if(itemlist.size()!=0) {
		itemcount = itemlist.size();
	}

	result.put("itemsearch",itemlist);
	result.put("itemcount",itemcount);

	resc.setResult(result);

	resc.setTarget("search");

	return resc;
	}
}
