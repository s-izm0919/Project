package commands.user;

import java.util.HashMap;
import java.util.Map;

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

		String inputPassword = reqc.getParameter("userPassword")[0];

		if(inputPassword == user.getUserPassword()) {
			dao.removeUser(user.getUserIdentifiedName(),user.getUserMail(),user.getUserPassword());
			System.out.println("ユーザーの削除(unused)");
			SessionManager.invalidate();
		}else {
			Map result = new HashMap();
			result.put("ngpass", "true");
			result.put("duplicateCheck", "false");
			resc.setResult(result);
			resc.setTarget("users/settings");
			return resc;
		}

		resc.setTarget("index");

		return resc;
	}
}
