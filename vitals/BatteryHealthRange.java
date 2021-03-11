package vitals;

/**
 * Enumeration for battery health parameter limits
 * @author PDH2COB
 * 
 */
public enum BatteryHealthRange {

	LOW_CHARGE_RATE_BREACH(0, 0.8f),

	LOW_CHARGE_RATE_WARNING(0.81f, 0.85f),

	NORMAL_CHARGE_RATE(0.81f, 0.95f),

	HIGH_CHARGE_RATE_WARNING(0.96f, 1.0f),

	HIGH_CHARGE_RATE_BREACH(1.0f, 1.05f),

	LOW_TEMP_BREACH(-05f, 0),

	LOW_TEMP_WARNING(0, 5),

	NORMAL_TEMP(6, 40),

	HIGH_TEMP_WARNING(40, 45),

	HIGH_TEMP_BREACH(45, 100),

	LOW_SOC_BREACH(0, 20),

	LOW_SOC_WARNING(21, 24),

	NORMAL_SOC(24, 75),

	HIGH_SOC_WARNING(76, 80),

	HIGH_SOC_BREACH(81, 100);

	private float min;
	private float max;

	BatteryHealthRange(float min, float max) {
		this.min = min;
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public float getMax() {
		return max;
	}

}
