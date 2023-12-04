package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData //'./' represents current directory
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Sheet1");	
			int totalcols=xlutil.getCellCount("Sheet1",1);
					
			String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //i= 1,j =0, i-1 is used to store the data in[0,0] row in array otherwise it will leave 1st row as empty
				}
			}
		return logindata;//returning two dimension array
					
		}
		
		//DataProvider 2
		
		//DataProvider 3
		
		//DataProvider 4
}
