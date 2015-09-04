package pl.grm.sm.desktop;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Kalendarz extends JPanel {

	private JLabel labelTitle;

	public Kalendarz() {
		labelTitle = new JLabel("Kalendarz");
		add(labelTitle);
	}
}
