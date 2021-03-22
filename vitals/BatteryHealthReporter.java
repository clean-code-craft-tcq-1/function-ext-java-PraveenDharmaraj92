package vitals;

import java.util.Properties;

public class BatteryHealthReporter implements IBatteryHealthChecker {

	private static final Properties LANGUAGE_PROPERTIES = BatteryMgmtProperties.getInstance().getLanguageProperties();
	private final Battery battery;

	public BatteryHealthReporter(final Battery battery) {
		this.battery = battery;
	}

	@Override
	public void checkHealth() {
		reportHealth(checkBatteryHealth(battery));
	}

	private void reportHealth(BatteryHealthResult result) {
		System.out.println(reportTemperatureStatus(result));
		System.out.println(reportChargeRateStatus(result));
		System.out.println(reportSocStatus(result));
	}

	/**
	 * @return Warning string if tolerance level > 0, else return Breach string
	 */
	private String getReportStatusString() {
		return Long.valueOf(
				BatteryMgmtProperties.getInstance().getOverallProperties().get(PropertyKeys.TOLERANCE).toString()) > 0
						? LANGUAGE_PROPERTIES.get(PropertyKeys.WARNING).toString()
						: LANGUAGE_PROPERTIES.get(PropertyKeys.VALUE_BREACH).toString();
	}

	private String reportTemperatureStatus(BatteryHealthResult result) {
		StringBuilder message = new StringBuilder();
		if (!result.isTemperatureOK()) {
			message.append(
					"Temperature "+ getReportStatusString() + " : " + LANGUAGE_PROPERTIES.getProperty(PropertyKeys.OPTIMAL_MINIMUM_VALUE)
							+ BatteryParameterRange.TEMPERATURE.getMin() + ". "
							+ LANGUAGE_PROPERTIES.getProperty(PropertyKeys.OPTIMAL_MAXIMUM_VALUE) + " "
							+ +BatteryParameterRange.TEMPERATURE.getMax());
			message.append("\n");
		}
		return message.toString();
	}

	private String reportSocStatus(BatteryHealthResult result) {
		StringBuilder message = new StringBuilder();
		if (!result.isSocOK()) {
			message.append("SOC "+ getReportStatusString() + " : " + LANGUAGE_PROPERTIES.getProperty(PropertyKeys.OPTIMAL_MINIMUM_VALUE)
					+ BatteryParameterRange.SOC.getMin() + ". "
					+ LANGUAGE_PROPERTIES.getProperty(PropertyKeys.OPTIMAL_MAXIMUM_VALUE)
					+ BatteryParameterRange.SOC.getMax());
			message.append("\n");
		}

		return message.toString();
	}

	private String reportChargeRateStatus(BatteryHealthResult result) {
		StringBuilder message = new StringBuilder();
		if (!result.isChargeRateOK()) {
			message.append(
					"Charge Rate "+ getReportStatusString() + " : " + LANGUAGE_PROPERTIES.getProperty(PropertyKeys.OPTIMAL_MINIMUM_VALUE)
							+ BatteryParameterRange.CHARGE_RATE.getMin() + ". "
							+ LANGUAGE_PROPERTIES.getProperty(PropertyKeys.OPTIMAL_MAXIMUM_VALUE) + " "
							+ BatteryParameterRange.CHARGE_RATE.getMax());
			message.append("\n");
		}
		return message.toString();
	}

}
