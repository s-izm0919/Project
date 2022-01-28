package commands.user;

import bean.User;
import commands.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;
import utility.SessionManager;


public class DepositeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc) {

	System.out.println("-- DepositeCommand -- ");

	AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
	UserDao userdao = factory.getUserDao();

	RequestContext reqc = getRequestContext();

	User user = (User)SessionManager.getAttribute("user");
	String userid =user.getUserId();
	System.out.println("入金前金額:"+user.getUserPoint());

	String userpoint = reqc.getParameter("userPoint")[0];

	System.out.println("入金額:"+userpoint);

	Integer addpoint = user.getUserPoint()+Integer.parseInt(userpoint);

	userdao.updatePoint(userid, addpoint.toString());

	user = userdao.getUserInfo(userid);

	System.out.println("入金後金額"+user.getUserPoint());

	SessionManager.setAttribute(user);

	resc.setTarget("index");

	return resc;
	}

}