package commands.item;
import java.util.ArrayList;

import bean.Shop;
import bean.ItemDetails;

import java.util.HashMap;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDetailsDao;
import dao.NewItemDao;
import bean.NewItem;





 public class ShowShopNewItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetShopInfoCommand -- ");
		RequestContext reqc = getRequestContext();
		String itemId=reqc.getParameter("itemId")[0];
		 System.out.println("itemId:"+itemId);





		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
	ItemDetailsDao dao=factory.getItemDetailsDao();
	ItemDetails itemDetails=dao.getItemDetails(itemId);
	String shopId=itemDetails.getShopId();
	System.out.println("shopId:"+shopId);
	AbstractDaoFactory newFactory=AbstractDaoFactory.getFactory();
	NewItemDao newDao= newFactory.getNewItemDao();

		ArrayList<NewItem> newItem=(ArrayList<NewItem>) newDao.getShopNewItems(shopId);
		HashMap result = new HashMap();
		result.put("historyList", newItem);
		resc.setResult(result);
		resc.setTarget("shop/items/newitem");



		return resc;

	}
}







