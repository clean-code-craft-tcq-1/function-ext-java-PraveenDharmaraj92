package vitals;

/**
 * Accumulator class that stores the result of health check
 */
public class BatteryHealthAccumulator implements IBatteryHealthChecker {

	private final Battery battery;

	private BatteryHealthResult result;

	public BatteryHealthAccumulator(final Battery battery) {
		this.battery = battery;
	}

	@Override
	public void checkHealth() {
		accumulateResult(checkBatteryHealth(battery));
	}

	public void accumulateResult(BatteryHealthResult result) {
		this.result = result;
	}

	public BatteryHealthResult getResult() {
		return result;
	}

}
