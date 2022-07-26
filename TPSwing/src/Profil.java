import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Profil extends JFrame {
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelEmail;
	private JLabel textNom;
	private JLabel textPrenom;
	private JLabel textEmail;
	private JButton bouttonModifier;
	private Controlleur controleur;
	public Profil(User user, Controlleur controleur) {
		this.setTitle("Formulaire");
		this.setSize(500, 300);
		this.initialiser(user, controleur);
		this.dessinner();
		this.executer();
		 
	}
	private void initialiser(User user, Controlleur controleur) {
		labelNom = new JLabel("Nom");
		labelPrenom = new JLabel("Prenom");
		labelEmail = new JLabel("Email");
		textNom = new JLabel(user.getNom());
		textPrenom = new JLabel(user.getPrenom());
		textEmail = new JLabel(user.getEmail());
		bouttonModifier = new JButton("Modifier");
		this.controleur=controleur;
	}
	private void dessinner() {
		this.setLayout(new BorderLayout());
		
		JPanel centre = new JPanel();
		centre.setLayout(new GridLayout(3,2));
		centre.add(labelNom);
		centre.add(textNom);
		centre.add(labelPrenom);
		centre.add(textPrenom);
		centre.add(labelEmail);
		centre.add(textEmail);
		
		this.add(centre, BorderLayout.CENTER);
		this.add(bouttonModifier, 
				BorderLayout.SOUTH);
	}
	private void colsing() {
		this.dispose();
	}
	private void executer() {
		bouttonModifier.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.modifierFormulaire(textNom.getText()
						,textPrenom.getText(),textEmail.getText());
						colsing();
						
					}
					
				});
	}
}
