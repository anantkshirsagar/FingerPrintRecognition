import com.mantra.manager.FingerPrintEventManager;
import com.mantra.model.Data;
import com.mantra.model.ExportData;

public class EventManager extends FingerPrintEventManager {

	@Override
	public void capturedData(ExportData exportData) {
		Data ansiTemplateData = exportData.getAnsiTemplateData();
		System.out.println(ansiTemplateData.getFilename());
		System.out.println(new String(ansiTemplateData.getData()));
	}	
}
