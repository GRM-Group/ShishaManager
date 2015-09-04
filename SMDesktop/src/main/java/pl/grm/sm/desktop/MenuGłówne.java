package pl.grm.sm.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuG³ówne extends JPanel {
	public MenuG³ówne(Desktop desktop) {
		JButton kalendarz = new JButton("Kalendarz");
		kalendarz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmieñStronê(Strona.KALENDARZ);

			}
		});
		add(kalendarz);
	}

}
