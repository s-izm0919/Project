package commands.shop;
import java.util.HashMap;
import java.util.Map;

import bean.Item;
import bean.Shop;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ItemDao;
import utility.ImageUpload;
import utility.SessionManager;

public class DisplayItemCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- DisplayItemCommand --");

		RequestContext reqc = getRequestContext();
		String shopId=null;

		 shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();

		System.out.println("shopId:"+shopId);
		if(shopId==null) {
			Map result=new HashMap();

				 System.out.println("shop does not exist");
				 result.put("mess", "まずはショップ登録してください。");
				 resc.setResult(result);
					resc.setTarget("guide/shop_open");
					return resc;
		}






		/*以下2文は画像処理*/

		ImageUpload ium = new ImageUpload();
		Map field = ium.upload(reqc);



		String itemName=(String)field.get("itemName");

		String itemPrice =(String)field.get("itemPrice");

		String mainImagePath=(String)field.get("mainImagePath");


		String itemExplanation=(String)field.get("itemExplanation");

		String categoryId=(String)field.get("categoryName");


		String itemDataPath=(String)field.get("itemDataPath");

		String itemIsOpen=(String)field.get("itemIsOpen");



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
/*
		if(checkShopId==false) {
			 System.out.println("shop does not exist");
			 result.put("mess", "まずはショップ登録してください。");
			 resc.setResult(result);
				resc.setTarget("shop/open");
				return resc;

		}
		*/


	 dao.addItem(item);

		System.out.println("item registered sucessfully");

		System.out.println("-- DisplayItemCommand --");

		resc.setTarget("index");
		return resc;
	}
}
