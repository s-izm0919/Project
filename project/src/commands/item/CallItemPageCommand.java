package commands.item;

import java.util.HashMap;
import java.util.Map;

import bean.ItemDetails;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDetailsDao;

public class CallItemPageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

		System.out.println("-- CallItemPageCommand -- ");

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemDetailsDao dao = factory.getItemDetailsDao();

		RequestContext reqc = getRequestContext();
		String itemId = reqc.getParameter("itemId")[0];
		System.out.println("itemID="+itemId);

		Map result = new HashMap();

		ItemDetails bean = (ItemDetails)dao.getItemDetails(itemId);

		System.out.println(bean.getItemName());

		result.put("itemdetails", bean);

		resc.setResult(result);

		resc.setTarget("items/item");

		return resc;

	}
}
