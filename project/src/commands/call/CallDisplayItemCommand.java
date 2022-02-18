package commands.call;

import java.util.HashMap;
import java.util.Map;

import bean.Shop;
import commands.AbstractCommand;
import context.ResponseContext;
import utility.SessionManager;

public class CallDisplayItemCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		String shopId=null;
		 shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopID:"+shopId);
		if(shopId==null) {
			Map result=new HashMap();

				 System.out.println("shop does not exist");
				 result.put("mess", "まずはショップ登録してください。");
				 resc.setResult(result);
					resc.setTarget("guide/shop_open");
					return resc;
		}

		resc.setTarget("shop/items/register/register");
		return resc;

	}
}
