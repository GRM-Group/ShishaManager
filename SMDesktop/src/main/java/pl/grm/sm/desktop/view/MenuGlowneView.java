package pl.grm.sm.desktop.view;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import pl.grm.sm.desktop.*;

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
