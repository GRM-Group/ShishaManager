package pl.grm.sm.desktop.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pl.grm.sm.desktop.Desktop;
import pl.grm.sm.desktop.Strona;

public class MenuG³ówneView extends JPanel {
	public MenuG³ówneView(Desktop desktop) {
		JButton kalendarz = new JButton("Kalendarz");
		kalendarz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmieñStronê(Strona.KALENDARZ);

			}
		});
		setLayout(new GridLayout(2, 1, 0, 0));
		add(kalendarz);
		JButton tytonie = new JButton("Tytonie");
		tytonie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmieñStronê(Strona.TYTONIE);

			}
		});
		add(tytonie);
	}

}
