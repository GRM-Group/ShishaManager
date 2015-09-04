package pl.grm.sm.desktop;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Desktop extends JFrame {
	private JPanel contentPane;
	private MenuG��wne menu;
	private Kalendarz kalendarz;

	public Desktop() {
		super();
		contentPane = new JPanel();
		setContentPane(contentPane); // <---- ustawia contentPane jako g��wny
										// panel programu/okna
		menu = new MenuG��wne(this);
		contentPane.add(menu);
		kalendarz = new Kalendarz();

	}

	public void zmie�Stron�(Strona strona) {
		contentPane.removeAll();

		switch (strona) {
		case KALENDARZ:
			contentPane.add(kalendarz);
			break;
		case MENUG��WNE:
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
