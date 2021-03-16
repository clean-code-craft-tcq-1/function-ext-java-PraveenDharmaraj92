package vitals;

/**
 * Dummy Controller for Battery health
 */
public class BatteryHealthController {

	private final BatteryManager manager;

	public BatteryHealthController(final BatteryManager manager) {
		this.manager = manager;
	}

	public BatteryManager getManager() {
		return manager;
	}
	
	

}
