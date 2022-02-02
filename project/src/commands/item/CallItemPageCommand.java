package commands.item;

import java.util.HashMap;
import java.util.Map;

import bean.ItemDetails;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDetailsDao;
import dao.HistoryDao;


import utility.SessionManager;

public class CallItemPageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- CallItemPageCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemDetailsDao dao = factory.getItemDetailsDao();

		RequestContext reqc = getRequestContext();
		String itemId = reqc.getParameter("itemId")[0];
		System.out.println("itemID="+itemId);

		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);

		AbstractDaoFactory historyFactory=AbstractDaoFactory.getFactory();
		HistoryDao historyDao = historyFactory.getHistoryDao();
		historyDao.addHistoryItem(userId, itemId);


		Map result = new HashMap();

		ItemDetails bean = (ItemDetails)dao.getItemDetails(itemId);

		System.out.println(bean.getItemName());

		result.put("itemdetails", bean);

		resc.setResult(result);

		resc.setTarget("items/item");

		return resc;

	}
}
