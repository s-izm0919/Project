package commands;
import dao.MySQLUserDao;
import context.ResponseContext;
import bean.Product;

import java.util.ArrayList;

import java.util.List;

class GetProductsCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetProductsCommand -- ");
		List<Product> products = new ArrayList<Product>();
		MySQLUserDao dao=new MySQLUserDao();
		products = dao.getAllProducts();


		resc.setResult(products);

		for (Product product : products) {
				System.out.println("pid: "+ product.getPid()+"Name: " + product.getName() + " Price: " + product.getPrice());
		}

		System.out.println("-- GetProductsCommand -- ");

	resc.setTarget("view");
		return resc;

	}
}


