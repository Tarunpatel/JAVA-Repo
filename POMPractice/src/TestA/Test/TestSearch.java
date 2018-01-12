package Test;

import org.testng.annotations.Test;

import Pages.Search;

public class TestSearch {
	Search objsearch;
	
	
	@Test(priority=0)
	public void test_Search() throws Throwable{
		objsearch = new Search(common.driver);
		Thread.sleep(2000);
		objsearch.searchparameter("Bogus", "B");
		objsearch.clickonsearch();
		objsearch.verifysearch();
}
}
