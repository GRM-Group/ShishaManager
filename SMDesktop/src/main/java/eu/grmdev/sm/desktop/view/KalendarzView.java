package eu.grmdev.sm.desktop.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eu.grmdev.sm.desktop.Desktop;

public class KalendarzView extends JPanel {

	private JLabel labelTitle;
	private Desktop desktop;

	public KalendarzView(Desktop desktop) {
		this.desktop = desktop;
		labelTitle = new JLabel("Kalendarz");
		add(labelTitle);
	}
}
