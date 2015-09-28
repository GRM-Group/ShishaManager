package pl.grm.sm.desktop;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KalendarzView extends JPanel {

	private JLabel labelTitle;
	private Desktop desktop;

	public KalendarzView(Desktop desktop) {
		this.desktop = desktop;
		labelTitle = new JLabel("Kalendarz");
		add(labelTitle);
	}
}
