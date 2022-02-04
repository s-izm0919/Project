package commands.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.ItemDetails;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.HistoryDao;
import dao.ItemDetailsDao;
import dao.NewItemDao;
import utility.SessionManager;

public class CallItemPageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		//商品単体を呼ぶページ

		System.out.println("-- CallItemPageCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemDetailsDao dao = factory.getItemDetailsDao();

		RequestContext reqc = getRequestContext();
		String itemId = reqc.getParameter("itemId")[0];
		System.out.println("itemID="+itemId);


		//System.out.println("userId"+userId);

		AbstractDaoFactory historyFactory=AbstractDaoFactory.getFactory();

		if(SessionManager.getToken("token")=="OK") {
			String userId=((User)SessionManager.getAttribute("user")).getUserId();
			HistoryDao historyDao = historyFactory.getHistoryDao();
			historyDao.addHistoryItem(userId, itemId);
		}

		Map result = new HashMap();

		ItemDetails bean = (ItemDetails)dao.getItemDetails(itemId);

		System.out.println(bean.getItemName());

		//ショップの新着情報も送る

		ItemDetailsDao itemdetaildao=factory.getItemDetailsDao();
		ItemDetails itemDetails=itemdetaildao.getItemDetails(itemId);
		String _shopId=itemDetails.getShopId();
		System.out.println("shopId:"+_shopId);
		AbstractDaoFactory newFactory=AbstractDaoFactory.getFactory();
		NewItemDao newDao= newFactory.getNewItemDao();

		ArrayList newItem=(ArrayList) newDao.getShopNewItems(_shopId);

		System.out.println(newItem);

		result.put("newItemList", newItem);

		result.put("itemdetails", bean);

		resc.setResult(result);

		resc.setTarget("items/item");

		return resc;

	}
}
