package commands;
import bean.Shop;
import dao.ShopDao;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;

public class AddShopCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddShopCommand --");

		RequestContext reqc = getRequestContext();


		String userId=reqc.getParameter("userId")[0];
		String shopName=reqc.getParameter("shopName")[0];
		String shopExplanation =reqc.getParameter("shopExplanation")[0];
		String sellerWord=reqc.getParameter("shopSellerword")[0];
		//String shopIsopen=reqc.getParameter("shopIspoen")[0];


		System.out.println("userId: " + userId);
		System.out.println("shopName: " + shopName);
		System.out.println("explanation: " + shopExplanation);
		System.out.println("sellerword: " + sellerWord);
		//System.out.println("isOpen: " + shopIsopen);

/*
		User user = new User();
		user.setUserIdentifiedName(nickName);
		user.setUserName(userName);
		user.setUserPassword(password);
		user.setUserMail(mail);
		*/

		Shop shop=new Shop();
		shop.setUserId(userId);
		shop.setShopName(shopName);
		shop.setShopExplanation(shopExplanation);
		shop.setShopSellerword(sellerWord);


		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();
		dao.addShop(shop);

		//reqc.setSession(shop);

		System.out.println("-- AddShopCommand --");

		resc.setTarget("index");
		return resc;
	}
}
