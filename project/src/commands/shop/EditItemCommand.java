package commands.shop;
import java.util.ArrayList;

import bean.Item;
import bean.Shop;
import bean.ShopItemList;
import java.util.HashMap;


import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDao;
import dao.ShopItemListDao;
import utility.SessionManager;



 public class EditItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- EditItemCommand -- ");
		RequestContext reqc = getRequestContext();

		String shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopId"+shopId);


		String itemName=reqc.getParameter("itemName")[0];
		System.out.println("itemName: " + itemName);

		String itemPrice =reqc.getParameter("itemPrice")[0];

		String mainImagePath=reqc.getParameter("mainImagePath")[0];


		String itemExplanation=reqc.getParameter("itemExplanation")[0];

		String categoryId=reqc.getParameter("categoryName")[0];


		String itemDataPath=reqc.getParameter("itemDataPath")[0];

		String itemIsOpen=reqc.getParameter("itemIsOpen")[0];

		String itemId=reqc.getParameter("itemId")[0];
		System.out.println("itemId"+itemId);



		//System.out.println("itemName: " + itemName);
		System.out.println("explanation: " + itemExplanation);
		System.out.println("imagePath: " + mainImagePath);
		System.out.println("price: " + itemPrice);
		System.out.println("isOpen: " + itemIsOpen);
		System.out.println("categoryId: " + categoryId);
		System.out.println("itemDataPath: " + itemDataPath);

		Item item=new Item();
		item.setItemId(Integer.parseInt(itemId));
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
		dao.updateItem(item);
		System.out.println("item updated sucessfully");
		ShopItemListDao shopDao=factory.getShopItemListDao();
		//List<ShopItemList> itemList=(List<ShopItemList>) dao.getItemList(shopId);
		ArrayList<ShopItemList> shopItemList=(ArrayList<ShopItemList>) shopDao.getItemList(shopId);
		HashMap result = new HashMap();
		result.put("shopItemResult", shopItemList);
		resc.setResult(result);
		resc.setTarget("shop/items/shopitemdetails");





		System.out.println("-- EditItemCommand --");

		resc.setTarget("index");
		return resc;









	}
}







