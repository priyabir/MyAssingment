package webpage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class resource {
	WebDriver driver;
	String table [] = new String[10];
	String a;
	String b;
	String Table_data[]=new String[12];
	String x;
	String y;
	String z;
	String Table_data2[][]=new String[6][12];
	By history =By.linkText("History(6)");
	String url="https://compass.esa.cognizant.com/psc/ESA89PRD/EMPLOYEE/ERP/c/RS_ASSIGNMENT.RS_MYASSIGNMENTS.GBL";  
	int Row_count1;
	int Col_count1;
	int Row_count2;
	public int Col_count2;
	
	public resource(WebDriver driver)
	{
		this.driver=driver;
	}

	public void navigate() {
		driver.navigate().to(url);
	}
	
	public void getCurrent() throws InterruptedException {
		a= "//tbody/tr[@id='RS_MYASSGNDS_WS$0_row_0']/td[";
		b = "]";
		 
		//To locate table.
		  WebElement mytable1 = driver.findElement(By.xpath("//tbody"));
		  //To locate rows of table.
		  List<WebElement> rows_table1 = mytable1.findElements(By.tagName("tr"));
		  //To calculate no of rows In table.
		  Row_count1 = rows_table1.size();
		  
		  //Loop will execute till the last row of table.
		  for (int row=0; row<Row_count1; row++){
		   //To locate columns(cells) of that specific row.
		   List<WebElement> Columns_row = rows_table1.get(row).findElements(By.tagName("td"));
		   //To calculate no of columns(cells) In that specific row.
		   Col_count1 = Columns_row.size();}
		  System.out.println(Row_count1+" "+ Col_count1);


		
		for(int i=1;i<=Row_count1;i++)		{
			for(int j=1;j<=Col_count1;j++)			{
				String final_xpath=a+j+b;
				Table_data[j]= driver.findElement(By.xpath(final_xpath)).getText();
			}
		}		
	}
	
	public void Sethistory() {
		driver.findElement(history).click();
	}
	
	public void getHistory() throws InterruptedException {
		x= "//tbody/tr[@id='RS_MYASSGNDS_WS$0_row_";
		y= "']/td[";
		z= "]";
		System.out.println();
		
		//To locate table.
		  WebElement mytable = driver.findElement(By.xpath("//tbody"));
		  //To locate rows of table.
		  List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		  //To calculate no of rows In table.
		  Row_count2 = rows_table.size();
		  
		  //Loop will execute till the last row of table.
		  for (int row=0; row<Row_count2; row++){
		   //To locate columns(cells) of that specific row.
		   List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		   //To calculate no of columns(cells) In that specific row.
		   Col_count2 = Columns_row.size();}
		  System.out.println(Row_count2+" "+ Col_count2);
		
		for(int i=0;i<Row_count2;i++)
		{
			for(int j=1;j<=Col_count2;j++)
			{
				String final_xpath2=x+i+y+j+z;
				Table_data2[i][j]= driver.findElement(By.xpath(final_xpath2)).getText();
			}
		}
		
	}
	public void var()
	{
		table[0]="Project ID      ";
		table[1]="Project Name    ";
		table[2]="Start Date      ";
		table[3]="End Date        ";
		table[4]="Percentage      ";
		table[5]="Billability     ";
		table[6]="Billability Role";
		table[7]="Manager ID      ";
		table[8]="Manager Name    ";
		table[9]="Status          ";
	}
	public void printCurrent() {
		var();
		System.out.println();	
		System.out.println("---------------------------Current Project Details -------------------------------");
		System.out.println();
		for(int i=1;i<=Row_count1;i++)		{
			for(int j=1;j<=Col_count1;j++)			{
			System.out.println(table[j-1]+"\t"+":"+"\t"+Table_data[j]+" ");
			}
		}	
	}
	public void printHistory() {
		var();	
		System.out.println();	
		System.out.println("---------------------------Hiatory Project Details -------------------------------");
		System.out.println();
		for(int i=0;i<Row_count2;i++) {
			for(int j=1;j<=Col_count2;j++) {
			System.out.println(table[j-1]+"\t"+":"+"\t"+Table_data2[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void writeExcelData() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet s1 = wb.createSheet("Current Sheet");
		XSSFSheet s2 = wb.createSheet("History Sheet");
		
		CellStyle style = wb.createCellStyle(); //Create new style
        style.setWrapText(true); //Set wordwrap
        
		XSSFRow row = s1.createRow(0);
		for(int j=0;j<Col_count1;j++)
		{
				s1.setColumnWidth(j, 6000);
				Cell cell= row.createCell(j);
				cell.setCellStyle(style); //Apply style to cell
				cell.setCellValue(table[j]);
		}
		XSSFRow row2 = s1.createRow(1);
		for(int j=0;j<Col_count1;j++)	
		{
				s1.setColumnWidth(j, 6000);
				Cell cell2= row2.createCell(j);
				cell2.setCellStyle(style); //Apply style to cell
				cell2.setCellValue(Table_data[j+1]);
		}
		//history excel 
		XSSFRow row1 = s2.createRow(0);
		for(int j=0;j<Col_count1;j++)
		{
				s2.setColumnWidth(j, 6000);
				Cell cell3= row1.createCell(j);
				cell3.setCellStyle(style);
				cell3.setCellValue(table[j]);
		}
		for(int i=0;i<Row_count2;i++)	
		{		 
				XSSFRow row3 = s2.createRow(i+1);
				for(int j=0;j<Col_count1;j++)	
				{
					s2.setColumnWidth(j, 6000);
					Cell cell4= row3.createCell(j);
					cell4.setCellStyle(style);
					row3.createCell(j).setCellValue(Table_data2[i][j+1]);
		}
	}	
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\PRIYA BIR\\eclipse-workspace\\Assignment\\output\\result.xlsx");
		wb.write(fileOut);
		wb.close();
}
}
