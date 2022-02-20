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
import utility.SessionManager;

public class AddShopCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddShopCommand --");

		RequestContext reqc = getRequestContext();
		Map result=new HashMap();


		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);




		String shopName=reqc.getParameter("shopName")[0];
		String shopExplanation =reqc.getParameter("shopExplanation")[0];
		String sellerWord=reqc.getParameter("shopSellerword")[0];

		String shopIsopen="1";
		shopIsopen=reqc.getParameter("shopIsOpen")[0];
		/*
		if("close".equals(shopIsopen)) {
			shopIsopen=""+0;

		}
		else shopIsopen=""+1;
		*/



		System.out.println("shopName: " + shopName);
		System.out.println("explanation: " + shopExplanation);
		System.out.println("sellerword: " + sellerWord);
		System.out.println("isOpen: " + shopIsopen);


		Shop shop=new Shop();
		shop.setUserId(userId);
		shop.setShopName(shopName);
		shop.setShopExplanation(shopExplanation);
		shop.setShopSellerword(sellerWord);
		shop.setShopIsOpen(Integer.parseInt(shopIsopen));


		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();
		boolean checkUserId=dao.checkUserId(userId);
		if(checkUserId==false) {
			 System.out.println("shop already exist");
			 result.put("mess", "ショップがすでに登録されています");
			 resc.setResult(result);
				resc.setTarget("shop/open");
				return resc;

		}

		else  dao.addShop(shop);
		Shop shopInfo=dao.getUserShopInfo(userId);
		System.out.println("shopId:"+shopInfo.getShopId());

		SessionManager.setAttribute(shopInfo);


		System.out.println("-- AddShopCommand --");

		resc.setTarget("top");
		return resc;
	}
}
