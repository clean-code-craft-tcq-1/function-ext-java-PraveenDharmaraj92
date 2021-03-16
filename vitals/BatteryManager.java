package vitals;

/**
 * Battery manager to control battery health functionalities
 */
public class BatteryManager {

	private final Battery battery;
	
	private BatteryHealthResult result;

	public BatteryManager(final Battery battery) {
		this.battery = battery;
	}

	public BatteryManager checkHealth() {
		result=new BatteryHealthCheckFunction().apply(battery);
		return this;
	}

	public void reportHealth() {
		if (BatteryManagementProperties.LANGUAGE.equals("English")) {
			new BatteryHealthReporterEnglish().apply(result);
		} else {
			new BatteryHealthReporterGerman().apply(result);
		}
	}

	public BatteryHealthResult getResult() {
		return result;
	}
	
	


}
