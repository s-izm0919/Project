package commands.shop;
import java.util.ArrayList;
import java.util.HashMap;

import bean.BoughtItemList;
import bean.Shop;
import bean.ShopItemEarning;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopItemEarningDao;
import utility.SessionManager;

public class ShowSingleItemEarningCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("--ShowSingleItemEarningCommand  --");

		RequestContext reqc = getRequestContext();


		String shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopId"+shopId);

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopItemEarningDao dao=factory.getShopItemEarningDao();
		ArrayList<  ShopItemEarning> itemEarning=(ArrayList<  ShopItemEarning>) dao.getShopItemEarning(shopId);

		System.out.println("shopuriaage:"+itemEarning);
		HashMap result = new HashMap();
		result.put("singleItemEarning", itemEarning);
		resc.setResult(result);
		resc.setTarget("shop/items/singleitemearning");


		return resc;
	}
}

