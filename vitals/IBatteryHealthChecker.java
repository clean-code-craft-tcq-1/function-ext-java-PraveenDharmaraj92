package vitals;

public interface IBatteryHealthChecker {
	
	/**
	 * @param battery battery with parameters
	 * @return battery health result
	 */
	public default BatteryHealthResult checkBatteryHealth(Battery battery){
		BatteryHealthChecker checker = new BatteryHealthChecker();
		return checker.apply(battery);
	}
	
	/**
	 * Method to check battery health
	 */
	public void checkHealth();

}
