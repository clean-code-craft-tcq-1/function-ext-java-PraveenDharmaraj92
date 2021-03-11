package vitals;

/**
 * @author PDH2COB
 * Class to store result of battery health check
 */
public class BatteryHealthResult {
	
	boolean socBreach;
	
	boolean temperatureBreach;
	
	boolean chargeRateBreach;
	
	boolean socWarning;
	
	boolean temperatureWarning;
	
	boolean chargeRateWarning;

	public boolean isSocBreach() {
		return socBreach;
	}

	public void setSocBreach(boolean socBreach) {
		this.socBreach = socBreach;
	}

	public boolean isTemperatureBreach() {
		return temperatureBreach;
	}

	public void setTemperatureBreach(boolean temperatureBreach) {
		this.temperatureBreach = temperatureBreach;
	}

	public boolean isChargeRateBreach() {
		return chargeRateBreach;
	}

	public void setChargeRateBreach(boolean chargeRateBreach) {
		this.chargeRateBreach = chargeRateBreach;
	}

	public boolean isSocWarning() {
		return socWarning;
	}

	public void setSocWarning(boolean socWarning) {
		this.socWarning = socWarning;
	}

	public boolean isTemperatureWarning() {
		return temperatureWarning;
	}

	public void setTemperatureWarning(boolean temperatureWarning) {
		this.temperatureWarning = temperatureWarning;
	}

	public boolean isChargeRateWarning() {
		return chargeRateWarning;
	}

	public void setChargeRateWarning(boolean chargeRateWarning) {
		this.chargeRateWarning = chargeRateWarning;
	}
	
	

}
