package commands.user;

import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;
import utility.SessionManager;

public class RemoveAccountCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();

		User user = (User)SessionManager.getAttribute("user");

		System.out.println(user.getUserName());

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		dao.removeUser(user.getUserIdentifiedName(),user.getUserMail(),user.getUserPassword());
		System.out.println("ユーザーの削除(unused)");

		SessionManager.invalidate();

		resc.setTarget("index");

		return resc;
	}
}
