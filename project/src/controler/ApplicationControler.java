
	package controler;
	import  context.RequestContext;
	import context.ResponseContext;

public interface ApplicationControler {
		RequestContext getRequest(Object request);
		ResponseContext handleRequest(RequestContext reqc);
		void handleResponse(RequestContext reqc,ResponseContext resc);



	}


