package commands;
import bean.User;
import bean.Shop;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopDao;;

class ShopSettingCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- ShopSettingCommandCommand -- ");


		RequestContext reqc = getRequestContext();
		String shopId=reqc.getParameter("shopId")[0];
		String userId = reqc.getParameter("userId")[0];

		String shopName= reqc.getParameter("shopName")[0];
		String shopExplanation  = reqc.getParameter("shopExplanation")[0];
		String sellerWord=reqc.getParameter("sellerWord")[0];

		System.out.println("shopid:"+shopId);
		System.out.println("userId:"+userId);


		System.out.println("shopName:"+shopName);
		System.out.println("usermail:"+shopExplanation);
		System.out.println("shopsellerword"+sellerWord);

		Shop shop=new Shop();
		shop.setUserId(userId);
		shop.setShopName(shopName);
		shop.setShopExplanation(shopExplanation);
		shop.setShopSellerword(sellerWord);


		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();
		dao.updateShop(shop);
		Shop newShopInfo=dao.getShopInfo(userId);
		System.out.println("newShopInfo:"+newShopInfo);
		if(newShopInfo!=null) {
			reqc.setSession(newShopInfo);

			resc.setTarget("index");

		}
return resc;





	}
}