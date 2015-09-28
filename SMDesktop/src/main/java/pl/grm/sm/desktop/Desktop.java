package pl.grm.sm.desktop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import pl.grm.sm.desktop.tytonie.TytonieView;

public class Desktop extends JFrame {
	private JPanel contentPane;
	private MenuG��wneView menu;
	private KalendarzView kalendarz;
	private TytonieView tytonie;

	public Desktop() {
		super();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		setContentPane(contentPane); // <---- ustawia contentPane jako g��wny
										// panel programu/okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Shisha manager");
		menu = new MenuG��wneView(this);
		kalendarz = new KalendarzView(this);
		tytonie = new TytonieView(this);
		zmie�Stron�(Strona.MENUG��WNE);
		setSize(300, 350);
		setLocationRelativeTo(null);
	}

	public void zmie�Stron�(Strona strona) {
		contentPane.removeAll();
		contentPane.invalidate();

		switch (strona) {
		case KALENDARZ:
			contentPane.add(kalendarz);
			break;
		case MENUG��WNE:
			contentPane.add(menu);
			break;
		case SHISHABARY:
			break;
		case TYTONIE:
			contentPane.add(tytonie);
			break;
		case WYDATKI:
			break;
		default:
			break;
		}
		contentPane.revalidate();
		contentPane.repaint();
	}
}
