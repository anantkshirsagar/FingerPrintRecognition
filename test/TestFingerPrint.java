import java.util.concurrent.ExecutionException;

import com.mantra.service.BiometricService;

public class TestFingerPrint {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		EventManager eventManager = new EventManager();
		BiometricService service = new BiometricService(eventManager);
		service.startCapture(55, 5000, true);
	}
}
