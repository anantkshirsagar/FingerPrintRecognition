import com.mantra.model.ExportData;
import com.mantra.service.BiometricService;

import MFS100.FingerData;

public class TestFingerPrint {
	public static void main(String[] args) throws InterruptedException {
		BiometricService service = new BiometricService();
		service.startCapture(55, 5000, true);
		//Thread.sleep(5000);
		FingerData fingerData = service.getFingerPrintEvent().getFingerData();
		ExportData exportData = service.getExportData(fingerData);
		
		System.out.println(new String(exportData.getIsoImageData().getData()));
		
	}
}
