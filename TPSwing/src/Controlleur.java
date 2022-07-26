
public class Controlleur {


	public Controlleur() {
		super();
	}
	
	public void demmarrer() {
		Formulaire formulaire = new Formulaire(this);
		formulaire.show();
	}
	public void validerFormulaire(String nom,
			String prenom, String email) {
		User u = new User(nom, prenom,email );
		Profil p = new Profil(u, this);
		p.show();
	}
	public void modifierFormulaire(String nom,
			String prenom, String email) {
		User user = new User(nom, prenom,email );
		Formulaire fenetre = new Formulaire(user,this);
		fenetre.show();
		
	}
	
}
