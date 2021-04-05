package vitals;

/**
 * Class to store result of battery health check
 */
public class BatteryHealthResult {
	
	private boolean socOk;
	
	private boolean temperatureOk;
	
	private boolean chargeRateOk;

	public boolean isSocOK() {
		return socOk;
	}

	public void setSocOK(boolean socOK) {
		this.socOk = socOK;
	}

	public boolean isTemperatureOK() {
		return temperatureOk;
	}

	public void setTemperatureOK(boolean temperatureOK) {
		this.temperatureOk = temperatureOK;
	}

	public boolean isChargeRateOK() {
		return chargeRateOk;
	}

	public void setChargeRateOK(boolean chargeRateOK) {
		this.chargeRateOk = chargeRateOK;
	}
	

	
}
