package pom.mercury.tours;

import org.testng.annotations.DataProvider;

public class ApplicationTestData {

	@DataProvider(name="Login")
	public Object[][] getDataFromDataProvider() {

		return new Object[][] {

			{"testing","testing"},
			{"dixit","dixit"},
			{"testabhi","testabhi"}
		};
	}


	//-------------------------------------------- This is to read Excel Data------------
/*
		@DataProvider(name = "LoginDataXLS")
		public Object[][] ExcelXLS() throws Exception{
			ReadXlsFile excel = new ReadXlsFile();
			Object[][] testObjArray = excel.getExcelData("C:\\Selenium_Training\\Selenium_Softwares\\workspace(akshata)\\MercuryTours_Maven\\MercuryTours.xls","Sign_On");
			System.out.println(testObjArray);
			return testObjArray;

		}
	*/	
		//-----------------This is to read XLSX Excel Data------------

		@DataProvider(name = "LoginDataXLSX")
		public Object[][] ExcelXLSX() throws Exception{
			ReadXlsXFile excel = new ReadXlsXFile();
			Object[][] testObjArray = excel.getExcelData("D:\\F Drive\\Selenium Training Data\\workspace\\Mecury_Tours_HCL_Maven\\LoginData.xlsx","Sign_On");
			System.out.println(testObjArray);
			return testObjArray;

		}

	
}