package commands.order;
import java.util.ArrayList;

import bean.User;
import bean.BoughtItemList;
import java.util.HashMap;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.BoughtItemListDao;
import utility.SessionManager;



 public class DisplayPurchasedItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- DisplayPurchasedItemCommand -- ");
		RequestContext reqc = getRequestContext();

		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId:"+userId);



		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		BoughtItemListDao dao=factory.getBoughtItemListDao();


		ArrayList<BoughtItemList> purchasedItem=(ArrayList<BoughtItemList>) dao.getAllOrderInfo(userId);
		HashMap result = new HashMap();
		result.put("purchasedItemResult", purchasedItem);
		resc.setResult(result);
		resc.setTarget("shop/items/purchaseditemdetails");



		return resc;

	}
}







