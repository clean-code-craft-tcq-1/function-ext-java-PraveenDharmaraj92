package vitals;

import java.util.function.Function;

/**
 * @author PDH2COB Health report in German
 */
public class BatteryHealthReporterGerman implements Function<BatteryHealthResult, String> {

	private String WARNING = " Warnung !";
	private String OPTIMAL_MINIMUM_VALUE = " Optimaler Mindestwert : ";
	private String OPTIMAL_MAXIMUM_VALUE = " Optimaler Maximalwert : ";

	@Override
	public String apply(final BatteryHealthResult result) {

		StringBuilder message = new StringBuilder();

		checkChargeRate(result, message);

		checkSoc(result, message);

		checkTemperature(result, message);

		System.out.println(message.toString());
		return message.toString();
	}

	private void checkTemperature(final BatteryHealthResult result, StringBuilder message) {
		if (result.isTemperatureBreach()) {
			message.append(
					"Temperaturwert verletzt !" + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_TEMP_BREACH.getMin()
							+ ". " + OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_TEMP_BREACH.getMax());
			message.append("\n");
		}

		if (result.isTemperatureWarning()) {
			message.append(WARNING + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_TEMP_WARNING.getMin() + ". "
					+ OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_TEMP_WARNING.getMax());
			message.append("\n");
		}
	}

	private void checkSoc(final BatteryHealthResult result, StringBuilder message) {
		if (result.isSocBreach()) {
			message.append("SOC-Wert verletzt!" + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_SOC_BREACH.getMin()
					+ ". " + OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_SOC_BREACH.getMax());
			message.append("\n");
		}

		if (result.isSocWarning()) {
			message.append(WARNING + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_SOC_WARNING.getMin() + ". "
					+ OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_SOC_WARNING.getMax());
			message.append("\n");
		}
	}

	private void checkChargeRate(final BatteryHealthResult result, StringBuilder message) {
		if (result.isChargeRateBreach()) {
			message.append(" Gebührensatzwert verletzt!" + OPTIMAL_MINIMUM_VALUE
					+ +BatteryHealthRange.HIGH_CHARGE_RATE_BREACH.getMin() + ". " + OPTIMAL_MAXIMUM_VALUE
					+ BatteryHealthRange.HIGH_CHARGE_RATE_BREACH.getMax());
			message.append("\n");
		}

		if (result.isChargeRateWarning()) {
			message.append(WARNING + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_CHARGE_RATE_WARNING.getMin() + ". "
					+ OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_CHARGE_RATE_WARNING.getMax());
			message.append("\n");
		}
	}

}
