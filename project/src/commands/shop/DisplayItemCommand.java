package commands.shop;
import bean.Item;

import bean.Shop;

import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDao;
import utility.SessionManager;

public class DisplayItemCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- DisplayItemCommand --");

		RequestContext reqc = getRequestContext();


		String shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopId:"+shopId);

/*  itemName,itemPrice,mainImagePath,itemExplanation,categoryName,imageDataPath,itemIsOpen */



		String itemName=reqc.getParameter("itemName")[0];

		String itemPrice =reqc.getParameter("itemPrice")[0];

		String mainImagePath=reqc.getParameter("mainImagePath")[0];


		String itemExplanation=reqc.getParameter("itemExplanation")[0];

		String categoryId=reqc.getParameter("categoryName")[0];


		String itemDataPath=reqc.getParameter("itemDataPath")[0];

		String itemIsOpen=reqc.getParameter("itemIsOpen")[0];



		System.out.println("itemName: " + itemName);
		System.out.println("explanation: " + itemExplanation);
		System.out.println("imagePath: " + mainImagePath);
		System.out.println("price: " + itemPrice);
		System.out.println("isOpen: " + itemIsOpen);
		System.out.println("categoryId: " + categoryId);
		System.out.println("itemDataPath: " + itemDataPath);

		Item item=new Item();
		item.setItemName(itemName);
		item.setItemPrice(Integer.parseInt(itemPrice));
		item.setItemExplanation(itemExplanation);
		item.setMainImagePath(mainImagePath);
		item.setCategoryId(Integer.parseInt(categoryId));
		item.setItemDataPath(itemDataPath);
		item.setShopId(shopId);
		item.setItemIsOpen(Integer.parseInt(itemIsOpen));





		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ItemDao dao=factory.getItemDao();
		dao.addItem(item);

		System.out.println("item registered sucessfully");

		System.out.println("-- DisplayItemCommand --");

		resc.setTarget("index");
		return resc;
	}
}
