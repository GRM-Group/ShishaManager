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
		zmie�Stron�(Strona.MENUG��WNE);
		kalendarz = new Kalendarz();
		pack();
	}

	public void zmie�Stron�(Strona strona) {
		contentPane.removeAll();

		switch (strona) {
			case KALENDARZ :
				contentPane.add(kalendarz);
				break;
			case MENUG��WNE :
				contentPane.add(menu);
				break;
			case SHISHABARY :
				break;
			case TYTONIE :
				break;
			case WYDATKI :
				break;
			default :
				break;
		}
		revalidate();
		contentPane.revalidate();
		pack();
	}
}
