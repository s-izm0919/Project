package commands.shop;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDao;

public class RemoveItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("----RemoveItemCommand----");
		RequestContext reqc = getRequestContext();
		String itemId=reqc.getParameter("itemId")[0];
		System.out.println("itemName: " + itemId);

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemDao dao=factory.getItemDao();
		dao.removeItem(Integer.parseInt(itemId));
		resc.setTarget("index");

		return resc;

	}
}

