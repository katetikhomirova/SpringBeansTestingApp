package com.kture.spring.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MainTest.class, UserServiceTest.class,
		ProductServiceTest.class, UserAccountsServiceTest.class,
		BuyingProductTest.class })
public class AllTests {

}
