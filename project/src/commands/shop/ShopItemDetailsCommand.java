package commands.shop;
import java.util.ArrayList;

import bean.Shop;
import bean.ShopItemList;
import java.util.HashMap;
import java.util.Map;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopItemListDao;
import utility.SessionManager;



 public class ShopItemDetailsCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetShopInfoCommand -- ");
		RequestContext reqc = getRequestContext();
String shopId=null;
		 shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopId"+shopId);
		if(shopId==null) {
			Map result=new HashMap();

				 System.out.println("shop does not exist");
				 result.put("mess", "まずはショップ登録してください。");
				 resc.setResult(result);
					resc.setTarget("guide/shop_open");
					return resc;
		}




		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopItemListDao dao=factory.getShopItemListDao();
		ArrayList<ShopItemList> shopItemList=(ArrayList<ShopItemList>) dao.getItemList(shopId);
		HashMap result = new HashMap();
		result.put("shopItemResult", shopItemList);
		resc.setResult(result);
		resc.setTarget("shop/items/shopitemdetails");



		return resc;

	}
}







