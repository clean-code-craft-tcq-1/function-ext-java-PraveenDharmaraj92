package vitals;

/**
 * Accumulator class that stores the result of health check
 */
public class BatteryHealthAccumulator implements IReporter{

	private final BatteryHealthController controller;
	
	private BatteryHealthResult result;
	
	public BatteryHealthAccumulator(final BatteryHealthController controller) {
		this.controller=controller;
	}
	@Override
	public void report() {
		controller.getManager().checkHealth();
		result = controller.getManager().getResult();
	}
	
	public BatteryHealthResult getResult(){
		if(result==null){
			report();
		}
		return result;
	}

}
