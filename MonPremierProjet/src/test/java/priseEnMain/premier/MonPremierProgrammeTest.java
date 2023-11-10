package priseEnMain.premier;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

class MonPremierProgrammeTest {

	@Test
	public void testMonPremierProgramme() {
		MonPremierProgramme test = new MonPremierProgramme("Fred");
		String affichage = test.moi();
		Assert.assertEquals("Ce n'est pas Fred!", "Fred", test.getPrenom());
		Assert.assertEquals("L'affichage est mauvais", "C'est Fred!", affichage);
	}
	
	@Test
	public void testMonPremierProgrammeAnglais() {
		Locale.setDefault(Locale.ENGLISH);
		MonPremierProgramme test = new MonPremierProgramme("John");
		
		String affichage = test.moi();
		
		Assert.assertEquals("Ce n'est pas John!", "John", test.getPrenom());
		Assert.assertEquals("Laffichage est mauvais", "It's John!", affichage);
		
		test.afficher();
	}
	
	@Test
	public void testMessages() {
		String string = null;
		try{
			string = Messages.getString("inexistant", Locale.FRENCH);
			Assert.fail("Message inconnu récupéré");
		}catch (MissingResourceException e) {
			Assert.assertNotNull(e);
		}
		
		string = Messages.getString("MonPremierProgramme.0", Locale.FRENCH);
		Assert.assertEquals("Mauvais format en français","C'est %s!", string);
		
		string = Messages.getString("MonPremierProgramme.0", Locale.ENGLISH);
		Assert.assertEquals("Mauvais format en anglais","It's %s!", string);
		
		string = Messages.getString("MonPremierProgramme.0", Locale.ITALIAN);
		Assert.assertEquals("Mauvais format en italien","C'est %s!", string);
		
	}
}