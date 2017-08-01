/**
 * 
 */
package com.bawei.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bawei.pojo.Employee;
/**
 * @author 陈凤祥
 * @date 2017-07-28
 * 
 * 拦截器
 * */
public class MyInterceotor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("!!!!!!!!!!!");
		System.out.println("------------------1");
		System.out.println("不知道");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

		System.out.println("------------------2");
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		
		HttpSession session = arg0.getSession();
		Employee reg = (Employee) session.getAttribute("reg");

		if(reg==null){
			System.out.println("跳转到登录页面");
			arg1.sendRedirect(arg0.getContextPath()+"/reg.jsp");
			return false;
		}
		return true;
	}

}
