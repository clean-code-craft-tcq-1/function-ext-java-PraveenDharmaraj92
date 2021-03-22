package vitals;

/**
 * Enumeration for battery health parameter limits
 * 
 */
public enum BatteryParameterRange {

	CHARGE_RATE(0.8f, 0.95f),

	TEMPERATURE(6.0f, 40.0f),

	SOC(24.0f, 75.0f);

	private float min;
	private float max;

	/**
	 * @param min - minimum value
	 * @param max - maximum value
	 */
	BatteryParameterRange(float min, float max) {
		this.min = min;
		this.max = max;
	}

	public float getMin() {
		float tolerance = getTolerance();
		if(tolerance>0){
			return (this.min-((tolerance/100)*this.min));
		}
		return min;
	}

	public float getMax() {
		float tolerance = getTolerance();
		if(tolerance>0){
			return (this.max+((tolerance/100)*this.max));
		}
		return max;
	}
	
	private float getTolerance(){
		return Float.valueOf(BatteryMgmtProperties.getInstance().getOverallProperties().get(PropertyKeys.TOLERANCE).toString());
	}

}
