import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire extends JFrame {
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelEmail;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textEmail;
	private JButton bouttonValider;
	private Controlleur controleur;
	public Formulaire(Controlleur controleur) {
		this.setTitle("Formulaire");
		this.setSize(500, 300);
		this.initialiser(controleur);
		this.dessinner();
		this.executer();
	}
	
	public Formulaire(User user, Controlleur controleur)  {
		this(controleur);
		this.textNom.setText(user.getNom()); 
		this.textPrenom.setText(user.getPrenom()); 
		this.textEmail.setText(user.getEmail()); 
	}

	private void initialiser(Controlleur controleur ) {
		labelNom = new JLabel("Nom");
		labelPrenom = new JLabel("Prenom");
		labelEmail = new JLabel("Email");
		textNom = new JTextField(30);
		textPrenom = new JTextField(30);
		textEmail = new JTextField(30);
		bouttonValider = new JButton("Valider");
		this.controleur = controleur;
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
		this.add(bouttonValider, 
				BorderLayout.SOUTH);
	}
	private void colsing() {
		this.dispose();
	}
	private void executer() {
		bouttonValider.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						controleur.validerFormulaire(textNom.getText()
						,textPrenom.getText(),textEmail.getText());
						colsing();
					}
				});
	}

}
