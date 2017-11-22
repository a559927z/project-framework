package net.chinahrd.eis.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.chinahrd.eis.annotation.FetchParams;

/**
 *
 * @author jxzhang on 2016年11月9日
 * @Verdion 1.0 版本
 */
@Aspect
@Component
public class ParamsAspect {

	private static Logger logger = LoggerFactory.getLogger(ParamsAspect.class);

	// @Pointcut("@annotation(net.chinahrd.eis.annotation.FetchParams)")
	// public void paramsAspect() {
	// }

	@Around("@annotation(fp)")
	public Object around(ProceedingJoinPoint pjp, FetchParams fp) throws Throwable {
		String param = fp.param();
		System.out.println("==================前置==================");
		System.out.println(param);
		Object obj = pjp.proceed();
		System.out.println("==================后置==================");
		return obj;
	}

}
