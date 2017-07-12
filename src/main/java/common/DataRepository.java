package common;

import auto.framework.DataTable;
import auto.framework.Resources;
import auto.framework.TestManager;
import auto.framework.DataTable.DataTableInstance;

public class DataRepository {

//	private static InheritableThreadLocal<DataTableInstance> enviTable = new InheritableThreadLocal<DataTableInstance>();
	private static InheritableThreadLocal<DataTableInstance> standardTestDataTable = new InheritableThreadLocal<DataTableInstance>();
	
//	public static DataTableInstance envi(){
//		DataTableInstance storedValue = enviTable.get();
//		if(storedValue != null) return storedValue;
//		DataTableInstance newValue = DataTable.Load( "./src/test/resources/data/envi/"+TestManager.Preferences.getPreference("environment")+".xls" );
//		enviTable.set(newValue);
//		return newValue;
//	}
	
	public static DataTableInstance testDataToBeUsed(){
		DataTableInstance storedValue = standardTestDataTable.get();
		if(storedValue != null) return storedValue;
		String dataFilePath = Resources.findResource("./src/test/resources/data/"+TestManager.Preferences.getPreference("data")+".xlsx"); 
		if(dataFilePath==null) {
			dataFilePath = "./src/test/resources/data/StandardTestData.xlsx";
		}
		DataTableInstance newValue = DataTable.Load( dataFilePath );
		standardTestDataTable.set(newValue);
		return newValue;
	}
	
//	public static DataTableInstance boost(){
//		return DataTable.Load( "./src/test/resources/data/cred/BOOST.xls" );
//	}

}
