package commands.shop;

import java.util.ArrayList;
import java.util.HashMap;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ShopOrderItemDetailsDao;


 public class ShowSingleOrderDetailsCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- ShowSingleOrderDetailsCommand -- ");
		RequestContext reqc = getRequestContext();

		String orderId=reqc.getParameter("orderId")[0];
		 System.out.println("orderId:"+orderId);


		ArrayList list = new ArrayList();
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ShopOrderItemDetailsDao dao=factory.getShopOrderItemDetailsDao();

		 list=(ArrayList)dao.getShopOrderDetails(orderId);
		 System.out.println(list);
		 //System.out.println(itemDetails);


		 //System.out.println("itemName:"+itemDetails.getItemName());

		 if(list.size()>0) {
		HashMap result = new HashMap();
		result.put("singleOrderDetails", list);
		resc.setResult(result);
		resc.setTarget("shop/items/singleorderdetails");
		 }



		return resc;

	}
}







