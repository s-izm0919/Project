package commands.shop;
import java.util.HashMap;
import java.util.Map;

import bean.Shop;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopDao;
import utility.SessionManager;;

 public class ShopSettingCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- ShopSettingCommandCommand -- ");


		RequestContext reqc = getRequestContext();

		System.out.println("testsetting");


		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId:"+userId);

String shopId=null;
		 shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopID:"+shopId);
		if(shopId==null) {
			Map result=new HashMap();

				 System.out.println("shop does not exist");
				 result.put("mess", "まずはショップ登録してください。");
				 resc.setResult(result);
					resc.setTarget("guide/shop_open");
					return resc;
		}




		String shopName= reqc.getParameter("shopName")[0];
		String shopExplanation  = reqc.getParameter("shopExplanation")[0];
		String sellerWord=reqc.getParameter("sellerWord")[0];
		String shopIsopen="1";
		shopIsopen=reqc.getParameter("shopIsOpen")[0];


		System.out.println("userId:"+userId);


		System.out.println("shopName:"+shopName);
		System.out.println("explanation:"+shopExplanation);
		System.out.println("shopsellerword:"+sellerWord);

		Shop shop=new Shop();
		shop.setUserId(userId);
		shop.setShopId(shopId);
		shop.setShopName(shopName);
		shop.setShopExplanation(shopExplanation);
		shop.setShopSellerword(sellerWord);
		shop.setShopIsOpen(Integer.parseInt(shopIsopen));


		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();
		dao.updateShop(shop);
		System.out.println("test-------");
		Shop newShopInfo=dao.getUserShopInfo(userId);
		System.out.println("newShopInfo:"+newShopInfo.getShopName());
		 			//reqc.setSession(newShopInfo);
			if(shop!=null) {
				SessionManager.setAttribute( newShopInfo);



			resc.setTarget("top");

		}
return resc;





	}
}