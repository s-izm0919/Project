package commands.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.Shop;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.CartDao;
import dao.ViewCartDao;
import utility.SessionManager;

public class CallCartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- CallCartCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		CartDao cartdao = factory.getCartDao();
		ViewCartDao viewcartdao = factory.getViewCartDao();

		RequestContext reqc = getRequestContext();

		User user = (User)SessionManager.getAttribute("user");
		String userid = user.getUserId();

		System.out.println("USERID:"+userid);

		Map result = new HashMap();

		ArrayList shoplist = (ArrayList)cartdao.getShopId(userid);

		System.out.println(shoplist.size());

		ArrayList cartitem = new ArrayList();

		ArrayList viewcart = new ArrayList();

		Shop shop = new Shop();

		for(int i=0;i<shoplist.size();i++){
			Shop s = (Shop)shoplist.get(i);

			String shopid = (String)s.getShopId();
			String shopname = (String)s.getShopName();

			cartitem.add(s);

			cartitem.add((ArrayList)viewcartdao.getCartItem(userid,shopid));

			System.out.println(cartitem);

			viewcart.add(cartitem);

			cartitem=new ArrayList();

		}

		System.out.println(viewcart);

		result.put("viewcart", viewcart);

		resc.setResult(result);

		resc.setTarget("cart/carts");

		return resc;

	}
}
