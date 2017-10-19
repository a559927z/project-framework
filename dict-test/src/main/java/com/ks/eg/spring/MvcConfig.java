package com.ks.eg.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ks.eg.spring.interceptor.CalcRequestTimeInterceptor;
import com.ks.eg.spring.interceptor.UrlInterceptor;

/**
 * @author jxzhang on 2017年09月01
 * @Verdion 1.0版本
 * 
 *          https://github.com/chenhaoxiang/springMVC/blob/master/springMVC3/README.md
 */
@Configuration // @Configuration 是最新的用注解配置spring，也就是说这是个配置文件，和原来xml配置是等效的
@EnableWebMvc // 开启SpringMVC支持，如无此注解，重写WebMvcConfigurerAdapter类的方法无效
@Component
@ComponentScan(basePackages = { "com.ks.eg.spring" }) // 告诉Spring 哪个packages 的用注解标识的类 会被spring自动扫描并且装入bean容器。
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean // 计算每一次请求的处理时间
	public CalcRequestTimeInterceptor calcRequestTimeInterceptorInstance() {
		return new CalcRequestTimeInterceptor();
	}

	@Bean // URL配置拦截器
	public UrlInterceptor urlInterceptorInstance() {
		return new UrlInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(urlInterceptorInstance()).addPathPatterns("/**");
		registry.addInterceptor(calcRequestTimeInterceptorInstance()).addPathPatterns("/**/**");
	}

	/**
	 * 视图解析 <bean class=
	 * "org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * 
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	/**
	 * 静态资源 <mvc:resources mapping="/assets/**" location="/assets/" />
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/assets/");
		// TODO 验正失败 addResourceHandler指的是对外暴露的访问路径,addResourceLocations指的是文件放置的目录
	}

	/**
	 * 此处无任何业务处理，只是简单的页面转向 快捷的ViewCOntroller
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/inn").setViewName("/in");
		// addViewController是访问的URL，setViewName是设置in.jsp
	}
}
