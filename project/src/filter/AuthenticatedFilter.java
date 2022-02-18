package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticatedFilter implements Filter {
    public void init(FilterConfig config)throws ServletException{

    }

    public void destroy(){

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        HttpSession session = ((HttpServletRequest)req).getSession();

        String flag = (String) session.getAttribute("token");

        if(flag==null){

            HttpServletRequest hreq =(HttpServletRequest)req;

            String servletPath = hreq.getServletPath();

            System.out.println(servletPath);

            hreq.setAttribute("target",servletPath);

            String loginaction = req.getParameter("loginaction");

            System.out.println(loginaction);

            if(loginaction != null) {
            	hreq.setAttribute("error","error");
            	System.out.println("動作");
            	System.out.println(hreq.getAttribute("error"));
            }

            RequestDispatcher dis = req.getRequestDispatcher("callsignin");
            dis.forward(req,res);

        }else{
            chain.doFilter(req,res);
        }
    }
}