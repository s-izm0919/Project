package commands.order;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDao;
import dao.OrderConfirmDao;
import dao.UserDao;
import utility.SessionManager;

public class ConfirmPasswordCommand extends AbstractCommand{
		public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- ConfirmPasswordCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao userdao = factory.getUserDao();
		ItemDao itemdao = factory.getItemDao();

		RequestContext reqc = getRequestContext();

		String password = reqc.getParameter("password")[0];
		String shopid = reqc.getParameter("shopId")[0];

		User user= (User)SessionManager.getAttribute("user");

		((HttpServletRequest)reqc.getRequest()).setAttribute("shopId",shopid);

		if(!(user.getUserPassword().equals(password))){

			resc.setTarget("orders/confirmpassword");

			return resc;

		}else {

			OrderConfirmDao orderdao = (OrderConfirmDao)factory.getOrderConfirmDao();

			String userid = user.getUserId();

			System.out.println(shopid+"///"+userid);

			Map result = new HashMap();

			result.put("confirmorder",orderdao.confirmOrder(userid, shopid));

			System.out.println(orderdao.confirmOrder(userid, shopid));

			resc.setResult(result);

			resc.setTarget("orders/confirmorder");

			return resc;
		}
	}
}
