package commands.user;

import java.util.ArrayList;
import java.util.HashMap;

import bean.HistoryList;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.HistoryDao;
import dao.HistoryListDao;
import utility.SessionManager;


public class DeleteHistoryCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

	System.out.println("-- DeleteHistoryCommand -- ");

	AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
	HistoryDao historydao = factory.getHistoryDao();

	String userId=((User)SessionManager.getAttribute("user")).getUserId();

	RequestContext reqc = getRequestContext();

	String itemId = reqc.getParameter("itemId")[0];

	historydao.removeHistoryItem(userId, itemId);

	HistoryListDao dao=factory.getHistoryListDao();

	ArrayList<HistoryList> viewedItem=(ArrayList<HistoryList>) dao.getHistory(userId);

	System.out.println(viewedItem);

;	HashMap result = new HashMap();
	result.put("historyList", viewedItem);
	resc.setResult(result);
	resc.setTarget("users/vieweditem");

	return resc;
	}
}
