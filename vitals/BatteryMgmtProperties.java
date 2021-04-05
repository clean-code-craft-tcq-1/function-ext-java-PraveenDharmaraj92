package vitals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BatteryMgmtProperties {

	private static BatteryMgmtProperties properties = new BatteryMgmtProperties();

	private final Properties overallProperties = new Properties();
	private final Properties languageProperties = new Properties();

	private BatteryMgmtProperties() {
		try {
			InputStream propertiesInputStream = getClass().getClassLoader()
					.getResourceAsStream("resources/BatteryManagement.properties");
			overallProperties.load(propertiesInputStream);
			String languagePropFile = overallProperties.get(PropertyKeys.LANGUAGE).toString();
			propertiesInputStream = getClass().getClassLoader().getResourceAsStream("resources/"+languagePropFile + ".properties");
			languageProperties.load(propertiesInputStream);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Properties getOverallProperties() {
		return overallProperties;
	}

	public Properties getLanguageProperties() {
		return languageProperties;
	}

	public static BatteryMgmtProperties getInstance() {
		if (null == properties) {
			properties = new BatteryMgmtProperties();
		}
		return properties;
	}

}
