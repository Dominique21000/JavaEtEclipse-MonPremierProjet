package priseEnMain.premier;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class Messages {
	private static final String BUNDLE_NAME = Messages.class.getPackageName() + ".messages"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private static final Map<Locale, ResourceBundle> BUNDLES = new HashMap<>();
	
	static {
		charge(Locale.FRENCH);
		charge(Locale.ENGLISH);
	}
	private Messages() {
	}

	private static void charge(Locale locale) {
		BUNDLES.put(locale, ResourceBundle.getBundle(BUNDLE_NAME, locale));
		
	}

	public static String getString(String key) {
		try {
			//return RESOURCE_BUNDLE.getString(key);
			return getString(key, Locale.getDefault());
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	static String getString(String key, Locale locale) {
		ResourceBundle bundle = BUNDLES.get(locale);
		Optional<ResourceBundle> opt = Optional.ofNullable(bundle);
		bundle = opt.orElse(BUNDLES.get(Locale.FRENCH));
		Stream<ResourceBundle> flux = Stream.of(bundle);
		Stream<String> trad = flux.map(rsc -> rsc.getString(key));
		return trad.findFirst().get();			
	}
}
