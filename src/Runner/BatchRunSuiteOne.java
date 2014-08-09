package Runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Test.CloseUrl;
import Test.Clothings;
import Test.LaunchUrl;
import Test.LoginTest;
import Test.MenShoesNewArrival;
import Test.MouseHoverNEWIN;
import Test.LinkInNewIn;
import Test.Shoes;
import Test.SignUp;


	 @RunWith(Suite.class)
	 @SuiteClasses({
		 LaunchUrl.class,
		 SignUp.class,
		 LoginTest.class,
		 MouseHoverNEWIN.class,
		 LinkInNewIn.class,
		 Shoes.class,
		 Clothings.class,
		 MenShoesNewArrival.class,
		 CloseUrl.class
		 })
	 public class BatchRunSuiteOne {
	
	 }

