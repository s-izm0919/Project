package commands;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import bean.Item;
import context.RequestContext;
import context.ResponseContext;

class TryCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {



	HashMap result = new HashMap();

	Item item = new Item();
	item.setItemName("サンプル");
	item.setItemPrice(200);

	ArrayList list = new ArrayList();
	list.add(new String("A"));
	list.add(new String("B"));
	list.add(new String("C"));

	result.put("item", item);
	result.put("list", list);

	resc.setResult(result);

	RequestContext reqc = getRequestContext();

	HttpServletRequest request = (HttpServletRequest)reqc.getRequest();

	String path=request.getServletContext().getRealPath("/upload");
	//実際にファイルが保存されるパス確認
	System.out.println(path);

	resc.setTarget("index");
		return resc;

	}
}