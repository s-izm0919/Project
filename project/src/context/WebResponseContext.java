package context;

import javax.servlet.http.HttpServletResponse;

public class WebResponseContext implements ResponseContext {
	private Object result; // Object型の代わりにBeanのスーパークラスでも可
	private String target;
	private HttpServletResponse response; // HttpServletResponseインターフェースの実装クラスのインスタンスを格納する

	public WebResponseContext() {}

	public void setTarget(String transferInfo) {
		target = "/WEB-INF/jsp/" + transferInfo + ".jsp";
	}

	// 転送先のViewに関する情報を返す
	public String getTarget() {
		return target;
	}

	public void setResult(Object bean) {
		result = bean;
	}

	// 処理結果を返す
	public Object getResult() {
		return result;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object object) {
		response = (HttpServletResponse) object;
	}
}
