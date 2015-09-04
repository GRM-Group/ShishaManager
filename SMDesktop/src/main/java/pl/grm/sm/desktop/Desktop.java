package pl.grm.sm.desktop;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Desktop extends JFrame {
	private JPanel contentPane;
	private MenuG³ówne menu;
	private Kalendarz kalendarz;

	public Desktop() {
		super();
		contentPane = new JPanel();
		setContentPane(contentPane); // <---- ustawia contentPane jako g³ówny
										// panel programu/okna
		menu = new MenuG³ówne(this);
		contentPane.add(menu);
		kalendarz = new Kalendarz();

	}

	public void zmieñStronê(Strona strona) {
		contentPane.removeAll();

		switch (strona) {
		case KALENDARZ:
			contentPane.add(kalendarz);
			break;
		case MENUG£ÓWNE:
			break;
		case SHISHABARY:
			break;
		case TYTONIE:
			break;
		case WYDATKI:
			break;
		default:
			break;

		}

	}
}
