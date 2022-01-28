package commands.shop;

import bean.Shop;
import bean.ItemEdit;
import java.util.HashMap;


import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemEditDao;


 public class SingleItemDetailsCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- SingleItemDetailsCommand -- ");
		RequestContext reqc = getRequestContext();

		String itemId=reqc.getParameter("itemId")[0];
		 System.out.println("itemId:"+itemId);


		ItemEdit itemInfo=null;
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemEditDao dao=factory.getItemEditDao();
		 itemInfo=dao.getItemDetails(Integer.parseInt(itemId));
		 System.out.println("itemInfo:"+itemInfo);
		 System.out.println("itemName:"+itemInfo.getItemName());

		 if(itemInfo!=null) {
		HashMap result = new HashMap();
		result.put("singleItemResult", itemInfo);
		resc.setResult(result);
		resc.setTarget("shop/items/edit/edit");
		 }



		return resc;

	}
}







