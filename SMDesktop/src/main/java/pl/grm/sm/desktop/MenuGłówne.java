package pl.grm.sm.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuGłówne extends JPanel {
	public MenuGłówne(Desktop desktop) {
		JButton kalendarz = new JButton("Kalendarz");
		kalendarz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmieńStronę(Strona.KALENDARZ);

			}
		});
		add(kalendarz);
	}

}
