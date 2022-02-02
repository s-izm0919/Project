package commands.user;
import java.util.ArrayList;

import bean.User;
import bean.HistoryList;
import bean.ShopItemList;
import java.util.HashMap;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.HistoryListDao;
import utility.SessionManager;



 public class ShowViewedItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetShopInfoCommand -- ");
		RequestContext reqc = getRequestContext();

		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);



		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		HistoryListDao dao=factory.getHistoryListDao();

		ArrayList<HistoryList> viewedItem=(ArrayList<HistoryList>) dao.getHistory(userId);
		HashMap result = new HashMap();
		result.put("historyList", viewedItem);
		resc.setResult(result);
		resc.setTarget("shop/items/history");



		return resc;

	}
}







