package commands;
import java.io.FileInputStream;

import context.RequestContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class CommandFactory {
	public static AbstractCommand getCommand(RequestContext reqc) {
		// name縺ｫ繧医▲縺ｦ逡ｰ縺ｪ繧気oncreteFactory繧定ｿ斐☆
		AbstractCommand command = null;
		Properties prop = new Properties();

		try {


			//prop.load(new FileInputStream("C:/Users/koyama/git/project/project/src/properties/commands.properties"));
			prop.load(CommandFactory.class.getClassLoader().getResourceAsStream("properties/commands.properties"));

			// 繧ｭ繝ｼ繧呈ｸ｡縺励※ConcreteFactory縺ｮ蜷榊燕繧貞叙蠕励＠縺ｾ縺�
			String name = prop.getProperty(reqc.getCommandPath());

			// 謖�螳壹＆繧後◆蜷榊燕縺ｮ縺上ｉ縺吶↓蟇ｾ蠢懊＠縺櫃lass繧ｯ繝ｩ繧ｹ縺ｮ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧貞叙蠕励☆繧具ｼ亥錐蜑阪�ｯ螳悟�ｨ髯仙ｮ壼錐縺ｧ縺ゅｋ縺薙→�ｼ�
			Class c = Class.forName(name);

			// Class繧ｯ繝ｩ繧ｹ縺ｮ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧貞茜逕ｨ縺励※蟇ｾ蠢懊☆繧九け繝ｩ繧ｹ縺ｮ繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ蛹悶ｒ陦後≧
			command = (AbstractCommand) c.newInstance();

		} catch (FileNotFoundException e) {
			// 螳滄圀縺ｫ縺ｯ迢ｬ閾ｪ萓句､悶↓繝ｩ繝�繝励＠縺ｦ繧ｹ繝ｭ繝ｼ縺吶ｋ
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			// 螳滄圀縺ｫ縺ｯ迢ｬ閾ｪ萓句､悶↓繝ｩ繝�繝励＠縺ｦ繧ｹ繝ｭ繝ｼ縺吶ｋ
			throw new RuntimeException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			// 螳滄圀縺ｫ縺ｯ迢ｬ閾ｪ萓句､悶↓繝ｩ繝�繝励＠縺ｦ繧ｹ繝ｭ繝ｼ縺吶ｋ
			throw new RuntimeException(e.getMessage(), e);
		} catch (InstantiationException e) {
			// 螳滄圀縺ｫ縺ｯ迢ｬ閾ｪ萓句､悶↓繝ｩ繝�繝励＠縺ｦ繧ｹ繝ｭ繝ｼ縺吶ｋ
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			// 螳滄圀縺ｫ縺ｯ迢ｬ閾ｪ萓句､悶↓繝ｩ繝�繝励＠縺ｦ繧ｹ繝ｭ繝ｼ縺吶ｋ
			throw new RuntimeException(e.getMessage(), e);
		}
		return command;
	}
}
