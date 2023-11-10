package priseEnMain.premier;

public class MonPremierProgramme {
	
	private String prenom;
	

	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public MonPremierProgramme(String prenom) {
		super();
		this.prenom = prenom;
	}


	/*
	 * 
	 
	public void moi() {
		MonPremierProgramme programme = new MonPremierProgramme("Moi");
		System.out.println("C'est " + programme.prenom + " !");
	}
	*/
	
	public String moi() {
		//return "C'est " + prenom + "!";
		return String.format(Messages.getString("MonPremierProgramme.0"), prenom); //$NON-NLS-1$
	}
	
	public void afficher() {
		System.out.println(moi());
	}

}
