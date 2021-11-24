package commands;
import dao.MySQLUserDao;
import context.ResponseContext;
import bean.User;

import java.util.ArrayList;

import java.util.List;

class GetUserCommand extends AbstractCommand {
	@SuppressWarnings("unchecked")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- GetUserCommand -- ");
		User users = new User();
		MySQLUserDao dao=new MySQLUserDao();
		users = dao.getUser("u10");


		resc.setResult(users);



	resc.setTarget("user_edit");
		return resc;

	}
}





