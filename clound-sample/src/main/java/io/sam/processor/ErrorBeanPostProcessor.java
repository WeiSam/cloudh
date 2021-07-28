package io.sam.processor;

import io.sam.db.service.AccountTblService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/1 14:29
 * 测试错误后置处理器替换bean
 */
//@Service
public class ErrorBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("执行AopBeanPostProcessor");
		if (bean instanceof AccountTblService) {
			AccountTblService accountTblService = new AccountTblService();
			return accountTblService;
		}
		return bean;
	}
}
