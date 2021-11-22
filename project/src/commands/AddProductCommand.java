package commands;
import dao.AbstractDaoFactory;
import context.RequestContext;
import context.ResponseContext;
import bean.User;
import dao.OraProductsDao;
import dao.ProductsDao;

public class AddProductCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddProductCommand --");

		RequestContext reqc = getRequestContext();

		String[] pids = reqc.getParameter("pid");
		String pid=pids[0];


		String[] names = reqc.getParameter("name");
		String name=names[0];
		//String name=reqc.getParameter("name")[0];

		String[] prices = reqc.getParameter("price");
		String price = prices[0];

		System.out.println("AddProductCommand: " + pid);
		System.out.println("AddProductCommand: " + price);
		System.out.println("AddProductCommand: " + name);


		User user = new user();
		user.setPid(pid);
		user.setName(name);
		user.setPrice(price);

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ProductsDao dao=factory.getProductsDao();
		dao.addProduct(user);

		System.out.println("-- AddProductCommand --");
		System.out.println("");


	resc.setTarget("start");
		return resc;
	}
}
//Map map = getParameters();
//String[] nameArray = (String[]) map.get("name");
//String[] priceArray = (String[]) map.get("price");
//
//String name = String.join("", nameArray);
//String price = String.join("", priceArray);
//
//System.out.println("AddProductCommand: " + name);
//System.out.println("AddProductCommand: " + price);
//
//Product product = new Product();
//product.setName(name);
//product.setPrice(price);
//
//DbDummy.addProduct(product);