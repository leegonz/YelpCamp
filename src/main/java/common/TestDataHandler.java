package common;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Fillo.Recordset;


public class TestDataHandler {

	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;
	
	public String url;
	public String column3;
	public String column4;
	public String column5;
	public String column6;
	public String column7;
	public String column8;
	public String column9;
	public String column10;
	public String column11;
	public String column12;
	public String column13;
	public String column14;
	public String column15;
	public String column16;
	public String column17;
	public String column18;
	public String column19;
	public String column20;
	public String column21;
	public String column22;
	public String column23;
	public String column24;
	public String column25;
	public String column26;
	public String column27;
	public String column28;
	public String column29;
	public String column30;
	public String column31;
	public String column32;
	public String column33;
	public String column34;
	public String column35;
	public String column36;
	public String column37;
	public String column38;
	public String column39;
	public String column40;
	public String column41;
	public String column42;
	public String column43;

	public static TestDataHandler loadTestData(String sheet, String... where) throws Exception {
		
		Recordset record = DataRepository.testDataToBeUsed().getRowData(sheet, where);
		return loadTestData(record);
	}

	public static TestDataHandler loadTestData(Recordset record) throws Exception {
		
		TestDataHandler testDataHandler = new TestDataHandler();
		testDataHandler.url = record.getField("URL");
		testDataHandler.column3 = record.getField("Column3");
		testDataHandler.column4 = record.getField("Column4");
		testDataHandler.column5 = record.getField("Column5");
		testDataHandler.column6 = record.getField("Column6");
		testDataHandler.column7 = record.getField("Column7");
		testDataHandler.column8 = record.getField("Column8");
		testDataHandler.column9 = record.getField("Column9");
		testDataHandler.column10 = record.getField("Column10");
		testDataHandler.column11 = record.getField("Column11");
		testDataHandler.column12 = record.getField("Column12");
		testDataHandler.column13 = record.getField("Column13");
		testDataHandler.column14= record.getField("Column14");
		testDataHandler.column15= record.getField("Column15");
		testDataHandler.column16= record.getField("Column16");
		testDataHandler.column17= record.getField("Column17");
		testDataHandler.column18= record.getField("Column18");
		testDataHandler.column19= record.getField("Column19");
		testDataHandler.column20= record.getField("Column20");
		testDataHandler.column21= record.getField("Column21");
		testDataHandler.column22= record.getField("Column22");
		testDataHandler.column23= record.getField("Column23");
		testDataHandler.column24= record.getField("Column24");
		testDataHandler.column25= record.getField("Column25");
		testDataHandler.column26= record.getField("Column26");
		testDataHandler.column27= record.getField("Column27");
		testDataHandler.column28= record.getField("Column28");
		testDataHandler.column29= record.getField("Column29");
		testDataHandler.column30= record.getField("Column30");
		testDataHandler.column31= record.getField("Column31");
		testDataHandler.column32= record.getField("Column32");
		testDataHandler.column33= record.getField("Column33");
		testDataHandler.column34= record.getField("Column34");
		testDataHandler.column35= record.getField("Column35");
		testDataHandler.column36= record.getField("Column36");
		testDataHandler.column37= record.getField("Column37");
		testDataHandler.column38= record.getField("Column38");
		testDataHandler.column39= record.getField("Column39");
		testDataHandler.column40= record.getField("Column40");
		testDataHandler.column41= record.getField("Column41");
		testDataHandler.column42= record.getField("Column42");
		testDataHandler.column43= record.getField("Column43");
		return testDataHandler;
		
	}
	
	private static int getRowContains(int colNum, String sTestCaseName) throws Exception{
		int i;

		try {
			
			int rowCount = getRowUsed();
			outer:
			for ( i=1 ; i < rowCount; i++){
  				if  (getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
	    			break outer;
				} 
			}
			return i;
				}catch (Exception e){
			throw(e);
			}
		}
	
	private static int getRowUsed() throws Exception {
			try{
				int RowCount = ExcelWSheet.getLastRowNum();
				return RowCount;
			}catch (Exception e){
				System.out.println(e.getMessage());
				throw (e);
			}

		} 
	
	 //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	 private static String getCellData(int RowNum, int ColNum) throws Exception{
	      String CellData = null;

	  	try{	        	   
	      	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);	        	  
	      	  //Cell.setCellType(Cell.CELL_TYPE_STRING);
	      	  CellData = Cell.getStringCellValue();
	       
	  	  		return CellData;
	            
	            }catch (Exception e){
	              return"";
	            }
	  }	  

	public static void loadIterativeTestData() throws Exception {
		//These steps iterates the input of Worksheet information which are derived from excel
        int lastRow = ExcelWSheet.getLastRowNum();
        System.out.println("Last Row with data is:  "+lastRow);
        //int rowcount = 0;
        int startrow = getRowContains(0, "CreateWorkSheetTest");
        System.out.println("start row is "+startrow);
        int rowUsed = 0;
        for (int i=0; i<lastRow+1; i++ ) {
               String testname = getCellData(i,0);
               //System.out.println(testname);
               if (testname.equalsIgnoreCase("CreateWorksheetTest")) {                           
                     rowUsed +=1;
               }                    
        }

	}
	
	public static String writeCellValue(int RowNum, int ColNum, String text ) throws Exception{
	      String text1 = "exception error";
	  	try{	        	   
	      	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	      	  System.out.println("setCellValue Row Number: "+RowNum+" and colnum "+ColNum);      	 
	      	  Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);      	    
	      	  String filepath = "C:\\Workspace\\WetravelProject\\src\\acn\\testdata\\SampleTestData.xlsx";
	      	  FileOutputStream webdata=new FileOutputStream(filepath);
	      	  Cell.setCellValue(text); 
	      	  ExcelWBook.write(webdata);
	      	  return text1;            
	            }catch (Exception e){
	            	return text1;
	            }
	  	}
	
}
