package org.jpanda.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jpanda.util.Constant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String requestUri = request.getRequestURI();
		System.out.println(requestUri);
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }
		
		
		HttpSession session = request.getSession();
		if (session.getAttribute(Constant.CURRENT_USER) == null) {
			throw new AuthorizationException();
			//return true;
			//response.sendRedirect(request.getContextPath()+ "/index");
			
		} else {
			return true;
		}
	        
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
