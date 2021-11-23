package commands;
import dao.MySQLUserDao;
import context.ResponseContext;
import bean.User;

import java.util.ArrayList;

import java.util.List;

class GetProductsCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetProductsCommand -- ");
		List<User> users = new ArrayList<User>();
		MySQLUserDao dao=new MySQLUserDao();
		users = dao.getAllUsers();


		resc.setResult(users);

		/*for (User product : products) {
				System.out.println("pid: "+ product.getPid()+"Name: " + product.getName() + " Price: " + product.getPrice());
		}


		System.out.println("-- GetProductsCommand -- ");
		*/

	resc.setTarget("view");
		return resc;

	}
}





