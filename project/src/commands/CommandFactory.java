package commands;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import context.RequestContext;

public abstract class CommandFactory {
	@SuppressWarnings("deprecation")
	public static AbstractCommand getCommand(RequestContext reqc) {

		AbstractCommand command = null;
		Properties prop = new Properties();

		try {


			//prop.load(new FileInputStream("C:/Users/koyama/git/project/project/src/properties/commands.properties"));
			prop.load(CommandFactory.class.getClassLoader().getResourceAsStream("properties/commands.properties"));


			System.out.println("パス ：" + reqc.getCommandPath());
			String name = prop.getProperty(reqc.getCommandPath());


			Class c = Class.forName(name);


			command = (AbstractCommand) c.newInstance();

		} catch (FileNotFoundException e) {

			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {

			throw new RuntimeException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {

			throw new RuntimeException(e.getMessage(), e);
		} catch (InstantiationException e) {

			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {

			throw new RuntimeException(e.getMessage(), e);
		}
		return command;
	}
}
