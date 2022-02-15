package commands.order;

import java.util.HashMap;

import bean.User;
import bean.UserOrderItemDetails;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserOrderItemDetailsDao;
import utility.SessionManager;


 public class ShowOrderDetailCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- ShowOrderDetailCommand -- ");
		RequestContext reqc = getRequestContext();
		String userId=((User)SessionManager.getAttribute("user")).getUserId();
		System.out.println("userId"+userId);


		String itemId=reqc.getParameter("itemId")[0];
		 System.out.println("itemId:"+itemId);
		 UserOrderItemDetails itemDetails=null;



		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserOrderItemDetailsDao dao=factory.getUserOrderItemDetailsDao();
		 itemDetails= dao.getOrderInfo(itemId, userId);
		 System.out.println(itemDetails);
		 System.out.println("itemPrice:"+itemDetails.getItemPrice());
		 System.out.println("itemName:"+itemDetails.getItemName());

		 if(itemDetails!=null) {
		HashMap result = new HashMap();
		result.put("singleItemDetails", itemDetails);
		resc.setResult(result);
		resc.setTarget("shop/items/singleitemdetails");
		 }



		return resc;

	}
}







