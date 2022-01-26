package commands.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.OrderConfirm;
import bean.Orders;
import bean.Shop;
import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.CartDao;
import dao.OrderConfirmDao;
import dao.OrderDetailDao;
import dao.OrdersDao;
import dao.ShopDao;
import dao.UserDao;
import utility.SessionManager;


public class ConfirmOrderCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

	System.out.println("-- ConfirmOrderCommand -- ");

	AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
	OrderConfirmDao orderconfirmdao = (OrderConfirmDao)factory.getOrderConfirmDao();

	RequestContext reqc = getRequestContext();

	//このあたりはOrderBeanをつくってる。
	String shopId = reqc.getParameter("shopId")[0];
	User user = (User)SessionManager.getAttribute("user");
	String userId = user.getUserId();
	int boostAmount = Integer.parseInt(reqc.getParameter("boost")[0]);
	OrderConfirm orderconfirm= (OrderConfirm)orderconfirmdao.confirmOrder(userId, shopId).get(0);
	int totalPayment = orderconfirm.getOrderPrice();

	System.out.println(shopId+"//"+userId+"//"+boostAmount+"//"+totalPayment);

	Orders order = new Orders();

	order.setUserId(userId);
	order.setShopId(shopId);
	order.setTotalPayment(totalPayment);
	order.setBoostAmount(boostAmount);

	//注文処理
	OrdersDao orderdao = (OrdersDao)factory.getOrdersDao();
	orderdao.addOrder(order);

	//注文詳細表に書き込み
	OrderDetailDao orderdetaildao = (OrderDetailDao)factory.getOrderDetailDao();

	ArrayList orderlist = (ArrayList)orderconfirmdao.confirmOrder(userId, shopId);

	System.out.println(orderlist);

	Orders user_order = orderdao.getOederId(userId, shopId);
	Integer orderId = user_order.getOrderId();

	System.out.println(user_order);
	System.out.println("注文番号:"+orderId);

	for(int i=0;i<orderlist.size();i++) {
		OrderConfirm item =(OrderConfirm)orderlist.get(i);
		System.out.println(item.getItemId());
		orderdetaildao.addOrderDetail(orderId.toString(), item.getItemId());
	}

	//カートから削除
	CartDao cartdao = factory.getCartDao();
	cartdao.removeCartItemShop(userId, shopId);

	//ユーザーのポイントを減らす
	int userpoint = orderconfirm.getUserPoint();

	Integer diff = userpoint-totalPayment-boostAmount;

	UserDao userdao = factory.getUserDao();
	userdao.updatePoint(userId, diff.toString());


	System.out.println("購入前残高:"+userpoint);
	System.out.println("差額計算:"+diff);
	System.out.println("ユーザーの残高:"+userdao.getPoint(userId).getUserPoint());

	//購入代金をショップユーザーに渡す
	ShopDao shopdao = factory.getShopDao();
	Shop shop = shopdao.getShopInfo(shopId);
	String shop_userid = shop.getUserId();

	Integer shoppoint = totalPayment+boostAmount;

	userdao.updatePoint(shop_userid, shoppoint.toString());


	//注文完了画面を表示する

	Map result = new HashMap();

	resc.setResult(result);

	resc.setTarget("orders/showorder");

	return resc;
	}
}