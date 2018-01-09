package PageEntity;

import Utilities.ReadExcel;


	public class LoginPageObject 
	{
		private static String BrowserName;
		
		private  String url;
		private String userName ;
		private String password ;
		private String title;
		private String ExpectedLoggedUser;
		
		public LoginPageObject(String sheetName) 
		{
			ReadExcel.syncPageData(this, sheetName);
		}

		public String getUrl()
		{
			return url;
			//System.out.println(url);
		}
		
		public void LoginPageObject2(String sheetName) 
		{
			ReadExcel.syncPageData(this, sheetName);
		}

		
		public String getUserName() 
		{
			return userName;
		}

		public String getPassword() 
		{
			return password;
		}
		
		public String getTitle(){
			return title;
		}
		
		public String getExptLoggedUser(){
			return ExpectedLoggedUser;
		}

		public String getBrowser() {
			return BrowserName;
		}
		
		
/*		
		
		public static void main(String[] args) {
			//System.out.println(BrowserName);
			LoginPageObject c = new LoginPageObject("Sheet1");
			//System.out.println(c.getBrowser());
			
		}*/
	}

