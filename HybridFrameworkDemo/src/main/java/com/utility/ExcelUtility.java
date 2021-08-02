import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public static Workbook wb;
	public static Sheet sh;
	
	//DataProvider Utility is used for getting Data from Excel ==>> Should be used with @DataProvider.
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.TESTDATASHEETNAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);
		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int k = 0; k < sh.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sh.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	@DataProvider
	public static String[][] getTableData(String path,String sheetName) throws Exception {
		String data[][] = null;
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		sh = wb.getSheet(sheetName);
		int row = sh.getPhysicalNumberOfRows();
		int col = sh.getRow(row-1).getPhysicalNumberOfCells();
		data = new String[row][col];
		for(int i=0;i<row-1;i++){ 
			for(int j=0;j<col;j++){ 
				Cell cell= sheet.getRow(i).getCell(j);
				System.out.println(cell.toString()+" ");
			} 
		}
		return data;
	}
	
	
	public static List<String> excelData(String sheetName) throws Exception {
		String data = null;
		List<String> expData = new ArrayList<String>();
		FileInputStream file=new FileInputStream("TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//sh = wb.getSheet(sheetName);
		int row = sh.getPhysicalNumberOfRows();
		System.out.println(row);
		int col = sh.getRow(row-1).getPhysicalNumberOfCells();
		Cell cell = null;
		data=new String();
		for (int i = 0;i<row;i++) {
			for(int j=0;j<col;j++){ 
				Cell cell1= sheet.getRow(i).getCell(j);
				 data=cell1.toString();
				 expData.add(data);
				}
		}
		return expData;
		}
	
	public static List<Map<String,String>> getTestDetails(String sheetname){
		List<Map<String,String>> list = null;

		try(FileInputStream fs = new FileInputStream(Constants.TESTDATASHEETNAME)) {
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();
			
			Map<String,String> map =null;
			list = new ArrayList<>();

			for(int i=1; i<=lastrownum;i++) { 
				map = new HashMap<>(); 
				for(int j=0;j<lastcolnum;j++) {
					String key= sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
