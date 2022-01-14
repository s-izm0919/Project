package commands;
import bean.User;
import bean.Shop;
import context.RequestContext;
import context.ResponseContext;
//import dao.MySQLUserDao;
import dao.ShopDao;
import dao.AbstractDaoFactory;
import filter.SessionManager;
//import dao.MySQLShopDao;


class GetShopInfoCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetShopInfoCommand -- ");
		RequestContext reqc = getRequestContext();
		//String userId = reqc.getParameter("user_id")[0];
		//System.out.println("userId"+userId);


		SessionManager.getSession(reqc);


		String userId=((User)SessionManager.getAttribute("result")).getUserId();
		System.out.println("userId"+userId);

		Shop shop=null;

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopDao dao=factory.getShopDao();




		shop = dao.getUserShopInfo(userId);
		System.out.println(shop);
		System.out.println("shopId:"+shop.getShopId());



		//resc.setResult(shop);
		if(shop!=null) {
			SessionManager.setAttribute( shop);
		}




		resc.setTarget("shop/shopinfo");
		return resc;

	}
}







