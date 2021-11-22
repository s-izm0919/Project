package commands;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import dao.AbstractDaoFactory;

public class AddUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- AddProductCommand --");

		RequestContext reqc = getRequestContext();


		//String[] names = reqc.getParameter("name");
		//String name=names[0];
		String nickName=reqc.getParameter("nickName")[0];
		String userName =reqc.getParameter("userName")[0];
		String password=reqc.getParameter("password")[0];
		String mail=reqc.getParameter("mail")[0];



		System.out.println("AddProductCommand: " + nickName);
		System.out.println("AddProductCommand: " + userName);
		System.out.println("AddProductCommand: " + password);
		System.out.println("AddProductCommand: " + mail);


		User user = new User();
		user.setUserIdentifiedName(nickName);
		user.setUserName(userName);
		user.setUserPassword(password);
		user.setUserMail(mail);




		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		ProductsDao dao=factory.getProductsDao();
		dao.addProduct(user);

		System.out.println("-- AddProductCommand --");
		System.out.println("");


	resc.setTarget("start");
		return resc;
	}
}