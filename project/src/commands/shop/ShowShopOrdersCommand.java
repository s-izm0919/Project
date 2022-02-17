package commands.shop;
import java.util.ArrayList;

import bean.Shop;
import bean.OrderList;
import java.util.HashMap;
import java.util.Map;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.OrderLIstDao;
import utility.SessionManager;



 public class ShowShopOrdersCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- DisplayPurchasedItemCommand -- ");
		RequestContext reqc = getRequestContext();
String shopId=null;
		 shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("ShopId:"+shopId);
		if(shopId==null) {
			Map result=new HashMap();

				 System.out.println("shop does not exist");
				 result.put("mess", "まずはショップ登録してください。");
				 resc.setResult(result);
					resc.setTarget("guide/shop_open");
					return resc;
		}


		ArrayList<OrderList> shopOrdersList=null;

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		//BoughtItemListDao dao=factory.getBoughtItemListDao();
		OrderLIstDao dao=factory.getOrderListDao();


		 shopOrdersList=(ArrayList<OrderList>) dao.getOrderList(shopId);
		 System.out.println("List:"+shopOrdersList);
		HashMap result = new HashMap();
		result.put("shopOrdersResult", shopOrdersList);

		resc.setResult(result);
		resc.setTarget("shop/items/shopordersdetails");



		return resc;

	}
}







