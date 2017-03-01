package eu.grmdev.sm.desktop.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import eu.grmdev.sm.desktop.Desktop;
import eu.grmdev.sm.desktop.Strona;

public class MenuGlowneView extends JPanel {
	
	public MenuGlowneView(Desktop desktop) {
		JButton kalendarz = new JButton("Kalendarz");
		kalendarz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.KALENDARZ);

			}
		});
		setLayout(new GridLayout(2, 1, 0, 0));
		add(kalendarz);
		JButton tytonie = new JButton("Tytonie");
		tytonie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.TYTONIE);

			}
		});
		add(tytonie);
	}

}
