package commands.shop;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Shop;
import bean.Orders;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.OrdersDao;
import utility.SessionManager;

public class ShowShopEarningCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("--ShowShopEarningCommand  --");

		RequestContext reqc = getRequestContext();

String shopId=null;
		 shopId=((Shop)SessionManager.getAttribute("shop")).getShopId();
		System.out.println("shopId"+shopId);
		if(shopId==null) {
			Map result=new HashMap();

				 System.out.println("shop does not exist");
				 result.put("mess", "まずはショップ登録してください。");
				 resc.setResult(result);
					resc.setTarget("shop/open");
					return resc;
		}




		 //今月
		Date nowdate = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM");
		String thisMonth = dateformat.format(nowdate);
		System.out.println(thisMonth);

		//先月
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowdate);
		calendar.add(Calendar.MONTH, -1);
		String lastMonth = dateformat.format(calendar.getTime());
		System.out.println(lastMonth);


		int totalEarning=0;

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		OrdersDao dao=factory.getOrdersDao();
		ArrayList<Orders> shopEarning=(ArrayList<Orders>)dao.getShopEarning(shopId, thisMonth);

		System.out.println(shopEarning);
		System.out.println(shopEarning.size());
		for( Orders index: shopEarning) {
		     totalEarning += index.getTotalPayment();
		   }
		System.out.println("totalEarning:"+totalEarning);

		HashMap result = new HashMap();
		result.put("shopEarning", shopEarning);
		result.put("totalEarning", totalEarning);
		resc.setResult(result);
		resc.setTarget("shop/items/shopearning");


		return resc;
	}
}

