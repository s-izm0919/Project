package commands;
import dao.MySQLUserDao;
import context.ResponseContext;
import bean.User;

import java.util.ArrayList;

import java.util.List;

class GetUserCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetProductsCommand -- ");
		User user = new User();
		MySQLUserDao dao=new MySQLUserDao();
		user = dao.getUser("u10");


		resc.setResult(user);

	resc.setTarget("users/user_edit");
		return resc;

	}
}





