package vitals;

import java.util.function.Function;

/**
 * @author PDH2COB
 *
 *Battery Health function to check health levels based on parameters
 */
public class BatteryHealthCheckFunction implements Function<Battery, BatteryHealthResult> {
	private BatteryHealthResult healthResult = new BatteryHealthResult();

	@Override
	public BatteryHealthResult apply(Battery battery) {
		
		if(BatteryManagementProperties.addTolerance){
			checkSocWithTolerance(battery);
			checkTemperatureWithTolerance(battery);
			checkChargeRateWithTolerance(battery);
		}
		else{
			checkSoc(battery);
			checkChargeRate(battery);
			checkTemperature(battery);
		}
		return healthResult;
	}
	
	private void checkChargeRate(Battery battery){
		healthResult.setChargeRateBreach(battery.getChargeRate() < BatteryHealthRange.LOW_CHARGE_RATE_BREACH.getMin()|| battery.getChargeRate() > BatteryHealthRange.HIGH_CHARGE_RATE_BREACH.getMax());
	}
	
	private void checkChargeRateWithTolerance(Battery battery){
		healthResult.setChargeRateWarning(battery.getChargeRate() < BatteryHealthRange.LOW_CHARGE_RATE_WARNING.getMin()|| battery.getChargeRate() > BatteryHealthRange.HIGH_CHARGE_RATE_WARNING.getMax());
	}
	
	private void checkSoc(Battery battery){
		healthResult.setSocBreach(battery.getSoc() < BatteryHealthRange.LOW_SOC_BREACH.getMin()|| battery.getSoc() > BatteryHealthRange.HIGH_SOC_BREACH.getMax());
	}
	
	private void checkSocWithTolerance(Battery battery){
		healthResult.setSocWarning(battery.getSoc() < BatteryHealthRange.LOW_SOC_WARNING.getMin()|| battery.getSoc() > BatteryHealthRange.HIGH_SOC_WARNING.getMax());
	}
	
	private void checkTemperature(Battery battery){
		healthResult.setTemperatureBreach(battery.getTemperature() < BatteryHealthRange.LOW_TEMP_BREACH.getMin()|| battery.getTemperature() > BatteryHealthRange.HIGH_TEMP_BREACH.getMax());
	}
	
	private void checkTemperatureWithTolerance(Battery battery){
		healthResult.setTemperatureWarning(battery.getTemperature() < BatteryHealthRange.LOW_TEMP_WARNING.getMin()|| battery.getTemperature() > BatteryHealthRange.HIGH_TEMP_WARNING.getMax());
	}
	

}
