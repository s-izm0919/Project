package commands.shop;
import bean.Shop;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
//import dao.MySQLUserDao;
import dao.ShopDao;
import utility.SessionManager;



 public class GetShopInfoCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetShopInfoCommand -- ");
		RequestContext reqc = getRequestContext();

		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);

		Shop shop=null;

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();

		shop = dao.getUserShopInfo(userId);
		System.out.println(shop);
		System.out.println("shopId:"+shop.getShopId());




		if(shop!=null) {
			SessionManager.setAttribute( shop);
		}




		resc.setTarget("shop/shopinfo");
		return resc;

	}
}







