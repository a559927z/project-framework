package net.chinahrd.mvc.pc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.chinahrd.eis.annotation.log.ControllerAop;

@Controller
public class LoginController extends BaseController {

	/**
	 * web里过滤器拦截：spring-shiro.xml里loginUrl属性绑定
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loginView", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("u") String userName, @RequestParam("p") String password, Model model) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try {
			subject.login(token);
			Session session = subject.getSession();
			System.out.println("sessionId:" + session.getId());
			System.out.println("sessionHost:" + session.getHost());
			System.out.println("sessionTimeout:" + session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("user", userName);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "loginView";
		}
	}

	/**
	 * js提交btn事件：提交过来请求
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public String
	// fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM)
	// String userName, Model model) {
	// model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM,
	// userName);
	// return "login";
	// }

	@ControllerAop(description = "退出登录", writeDb = true, type = 2)
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
		}
		return "/";
	}

}
