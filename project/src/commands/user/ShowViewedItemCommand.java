package commands.user;
import java.util.ArrayList;
import java.util.HashMap;

import bean.HistoryList;
import bean.User;
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
		System.out.println(viewedItem);
;		HashMap result = new HashMap();
		result.put("historyList", viewedItem);
		resc.setResult(result);
		resc.setTarget("users/vieweditem");



		return resc;

	}
}







