package commands.shop;
import java.util.HashMap;

import bean.Shop;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopDao;
import utility.SessionManager;

public class ShowShopEarningCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("--ShowShopEarningCommand  --");

		RequestContext reqc = getRequestContext();


		String shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopId"+shopId);






		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();
		int shopEarning=dao.getShopEarning(shopId);

		System.out.println("shopuriaage:"+shopEarning);
		HashMap result = new HashMap();
		result.put("shopEarning", shopEarning);
		resc.setResult(result);
		resc.setTarget("shop/items/shopearning");


		return resc;
	}
}

