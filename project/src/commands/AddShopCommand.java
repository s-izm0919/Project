package commands;
import bean.Shop;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopDao;
import filter.SessionManager;

public class AddShopCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddShopCommand --");

		RequestContext reqc = getRequestContext();
		boolean f=false;

		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);




		String shopName=reqc.getParameter("shopName")[0];
		String shopExplanation =reqc.getParameter("shopExplanation")[0];
		String sellerWord=reqc.getParameter("shopSellerword")[0];

		String shopIsopen=reqc.getParameter("shopIsOpen")[0];
		if("close".equals(shopIsopen)) {
			shopIsopen=""+0;

		}
		else shopIsopen=""+1;


		System.out.println("userId: " + userId);
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
		dao.addShop(shop);

		SessionManager.setAttribute(shop);



		//reqc.setSession(shop);

		System.out.println("-- AddShopCommand --");

		resc.setTarget("index");
		return resc;
	}
}
