package com.kture.spring.market;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kture.spring.facade.Market;
import com.kture.spring.facade.MarketFacade;

public class MarketFactory {

	private static MarketFacade market;

	public static synchronized MarketFacade getMarket() {
		if (market == null) {
			ApplicationContext appContext = new ClassPathXmlApplicationContext(
					new String[] { "application-context.xml" });
			market = (Market) appContext.getBean("market");
		}
		return market;
	}

}
