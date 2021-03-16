package vitals;

/**
 * Class for reporting health status to console
 */
public class LogReporter implements IReporter{
	
	private final BatteryManager manager;
	
	public LogReporter(BatteryManager manager) {
		this.manager = manager;
	}

	@Override
	public void report() {
		if(manager.getResult()==null){
			manager.checkHealth();
		}
		manager.reportHealth();
	}

}
