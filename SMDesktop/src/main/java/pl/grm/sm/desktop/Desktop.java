package pl.grm.sm.desktop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import pl.grm.sm.desktop.tytonie.TytonieView;

public class Desktop extends JFrame {
	private JPanel contentPane;
	private MenuGłówneView menu;
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
		setContentPane(contentPane); // <---- ustawia contentPane jako główny
										// panel programu/okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Shisha manager");
		menu = new MenuGłówneView(this);
		kalendarz = new KalendarzView(this);
		tytonie = new TytonieView(this);
		zmieńStronę(Strona.MENUGŁÓWNE);
		setSize(300, 350);
		setLocationRelativeTo(null);
	}

	public void zmieńStronę(Strona strona) {
		contentPane.removeAll();
		contentPane.invalidate();

		switch (strona) {
		case KALENDARZ:
			contentPane.add(kalendarz);
			break;
		case MENUGŁÓWNE:
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
