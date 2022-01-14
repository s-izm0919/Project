package commands;
import bean.Shop;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopDao;
import filter.SessionManager;;

class ShopSettingCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- ShopSettingCommandCommand -- ");


		RequestContext reqc = getRequestContext();
		//String shopId=reqc.getParameter("shopId")[0];
		//String userId = reqc.getParameter("userId")[0];
		System.out.println("testsetting");


		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);


		String shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shop"+shopId);



		String shopName= reqc.getParameter("shopName")[0];
		String shopExplanation  = reqc.getParameter("shopExplanation")[0];
		String sellerWord=reqc.getParameter("sellerWord")[0];

		System.out.println("shopid:"+shopId);
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


		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();
		dao.updateShop(shop);
		System.out.println("test-------");
		Shop newShopInfo=dao.getUserShopInfo(userId);
		System.out.println("newShopInfo:"+newShopInfo.getShopName());
		 			//reqc.setSession(newShopInfo);
			if(shop!=null) {
				SessionManager.setAttribute( newShopInfo);



			resc.setTarget("index");

		}
return resc;





	}
}