package commands.shop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.Shop;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
//import dao.MySQLUserDao;
import dao.ShopDao;
import dao.ShopItemListDao;



 public class GetShopInfoCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetShopInfoCommand -- ");
		RequestContext reqc = getRequestContext();

		Shop shopInfo=null;

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();

		String shopId = reqc.getParameter("shopId")[0];

		shopInfo = dao.getShopInfo(shopId);

		Map result = new HashMap();

		result.put("shopInfo",shopInfo);

		System.out.println("shopId:"+shopInfo.getShopId());

		ShopItemListDao shopitemlistdao = factory.getShopItemListDao();

		ArrayList itemList = (ArrayList)shopitemlistdao.getItemList(shopId);

		System.out.println(itemList);

		result.put("itemList",itemList);

		resc.setResult(result);

		resc.setTarget("shop/shopinfo");
		return resc;

	}
}







