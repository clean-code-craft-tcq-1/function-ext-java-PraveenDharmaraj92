package vitals;

import java.util.function.Function;

/**
 * @author PDH2COB
 * Health report in english 
 */
public class BatteryHealthReporterEnglish implements Function<BatteryHealthResult, String> {

	private static final String WARNING = " Warning !";
	private static final String OPTIMAL_MAXIMUM_VALUE = "Optimal maximum value : ";
	private static final String OPTIMAL_MINIMUM_VALUE = " Optimal minimum value : ";

	@Override
	public String apply(final BatteryHealthResult result) {

		StringBuilder message = new StringBuilder();

		if (result.isChargeRateBreach()) {
			message.append(" Charge rate value breached!" + OPTIMAL_MINIMUM_VALUE
					+ BatteryHealthRange.HIGH_CHARGE_RATE_BREACH.getMin() + ". " + OPTIMAL_MAXIMUM_VALUE
					+ BatteryHealthRange.HIGH_CHARGE_RATE_BREACH.getMax());
			message.append("\n");
		}

		if (result.isChargeRateWarning()) {
			message.append(
					WARNING + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_CHARGE_RATE_BREACH.getMin()
							+ ". " + OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_CHARGE_RATE_BREACH.getMax());
			message.append("\n");
		}

		if (result.isSocBreach()) {
			message.append(
					" SOC value breached!" + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_SOC_BREACH.getMin()
							+ ". " + OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_SOC_BREACH.getMax());
			message.append("\n");
		}

		if (result.isSocWarning()) {
			message.append(WARNING + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_SOC_BREACH.getMin()
					+ ". " + OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_SOC_BREACH.getMax());
			message.append("\n");
		}

		if (result.isTemperatureBreach()) {
			message.append(" Temperature value breached!" + OPTIMAL_MINIMUM_VALUE
					+ BatteryHealthRange.HIGH_TEMP_BREACH.getMin() + ". " + OPTIMAL_MAXIMUM_VALUE
					+ BatteryHealthRange.HIGH_TEMP_BREACH.getMax());
			message.append("\n");
		}

		if (result.isTemperatureWarning()) {
			message.append(WARNING + OPTIMAL_MINIMUM_VALUE + BatteryHealthRange.HIGH_TEMP_BREACH.getMin()
					+ ". " + OPTIMAL_MAXIMUM_VALUE + BatteryHealthRange.HIGH_TEMP_BREACH.getMax());
			message.append("\n");
		}

		System.out.println(message.toString());
		return message.toString();
	}

}
