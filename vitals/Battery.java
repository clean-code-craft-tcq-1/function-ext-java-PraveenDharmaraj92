package vitals;

/**
 * Class with battery parameters
 */
public class Battery {

	private final float temperature;

	private final float chargeRate;

	private final float soc;

	public Battery(final float temperature, final float chargeRate, final float soc) {
		super();
		this.temperature = temperature;
		this.chargeRate = chargeRate;
		this.soc = soc;
	}

	public float getTemperature() {
		return temperature;
	}

	public float getChargeRate() {
		return chargeRate;
	}

	public float getSoc() {
		return soc;
	}

}
