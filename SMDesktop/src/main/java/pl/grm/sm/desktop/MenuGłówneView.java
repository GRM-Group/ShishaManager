package pl.grm.sm.desktop;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuG��wneView extends JPanel {
	public MenuG��wneView(Desktop desktop) {
		JButton kalendarz = new JButton("Kalendarz");
		kalendarz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmie�Stron�(Strona.KALENDARZ);

			}
		});
		setLayout(new GridLayout(2, 1, 0, 0));
		add(kalendarz);
		JButton tytonie = new JButton("Tytonie");
		tytonie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmie�Stron�(Strona.TYTONIE);

			}
		});
		add(tytonie);
	}

}
