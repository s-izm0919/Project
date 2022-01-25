package commands.cart;

import java.util.HashMap;
import java.util.Map;

import bean.Cart;
import bean.User;
import bean.ViewCart;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.CartDao;
import dao.ViewCartDao;
import utility.SessionManager;

public class AddCartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- AddCartCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		CartDao cartdao = factory.getCartDao();
		ViewCartDao viewcartdao = factory.getViewCartDao();

		RequestContext reqc = getRequestContext();
		String itemid = reqc.getParameter("itemId")[0];

		User user = (User)SessionManager.getAttribute("user");
		String userid = user.getUserId();

		System.out.println("USERID:"+userid+"    ITEMID="+itemid);

		Map result = new HashMap();

		Cart cart = (Cart)cartdao.checkCart(userid, itemid);
		System.out.println(cart.getItemId());
		if(cart.getItemId() != Integer.parseInt(itemid)){
			cartdao.addCart(userid, itemid);
		}else {
			System.out.println("登録重複 USERID:"+userid+"    ITEMID="+itemid);
			System.out.println("その商品はすでに登録されています");
		}

		ViewCart viewcart = viewcartdao.getOneCartItem(userid, itemid);

		System.out.println(viewcart.getItemName());
		System.out.println(viewcart.getShopName());


		result.put("viewcart", viewcart);

		resc.setResult(result);

		resc.setTarget("cart/addcart");

		return resc;

	}
}