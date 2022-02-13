package commands;

import java.util.ArrayList;
import java.util.HashMap;

import bean.HistoryList;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.HistoryListDao;
import utility.SessionManager;

public class TopCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		HashMap result = new HashMap();
		ArrayList<HistoryList> viewedItem = new ArrayList<HistoryList>();

		//履歴を呼ぶためのコード
		if(SessionManager.getToken()=="OK") {
			RequestContext reqc = getRequestContext();

			String userId=((User)SessionManager.getAttribute("user")).getUserId();
			System.out.println("userId"+userId);



			AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
			HistoryListDao dao=factory.getHistoryListDao();

			viewedItem=(ArrayList<HistoryList>) dao.getHistory(userId);

			System.out.println(viewedItem);
		}

		result.put("historyList", viewedItem);
		resc.setResult(result);
		resc.setTarget("top");
		return resc;

	}

}
