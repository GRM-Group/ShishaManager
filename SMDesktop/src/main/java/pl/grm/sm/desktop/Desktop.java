package pl.grm.sm.desktop;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import pl.grm.sm.core.DBHandler;
import pl.grm.sm.core.sql.DBConnection;
import pl.grm.sm.desktop.presenters.NowyTytonPresenter;
import pl.grm.sm.desktop.view.KalendarzView;
import pl.grm.sm.desktop.view.MenuG³ówneView;
import pl.grm.sm.desktop.view.ShishaBaryView;
import pl.grm.sm.desktop.view.WydatkiView;
import pl.grm.sm.desktop.view.tytonie.MarkaView;
import pl.grm.sm.desktop.view.tytonie.MarkiView;
import pl.grm.sm.desktop.view.tytonie.NowyTytoñView;
import pl.grm.sm.desktop.view.tytonie.SmakView;
import pl.grm.sm.desktop.view.tytonie.SmakiView;
import pl.grm.sm.desktop.view.tytonie.TytonieView;
import pl.grm.sm.desktop.view.tytonie.TytoñView;
import pl.grm.sm.desktop.view.tytonie.WszystkieTytonieView;
public class Desktop extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuG³ówneView menu;
	private KalendarzView kalendarz;
	private TytonieView tytonie;
	private ShishaBaryView shishabary;
	private WydatkiView wydatki;
	private WszystkieTytonieView wszystkie;
	private MarkaView marka;
	private MarkiView marki;
	private SmakView smak;
	private SmakiView smaki;
	private TytoñView tytoñ;
	private NowyTytoñView nowytytoñ;
	private DBHandler dbhandler;
	
	public Desktop() {
		super();
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		setContentPane(contentPane); // <---- ustawia contentPane jako g³ówny
										// panel programu/okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Shisha manager");
		
		stworzStrony();
		
		setSize(360, 600);
		setLocationRelativeTo(null);
		try {
			dbhandler = DBConnection.createNewDBHandler("conf.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		zmieñStronê(Strona.MENUG£ÓWNE);
	}
	
	private void stworzStrony() {
		menu = new MenuG³ówneView(this);
		kalendarz = new KalendarzView(this);
		shishabary = new ShishaBaryView(this);
		tytonie = new TytonieView(this);
		wydatki = new WydatkiView(this);
		wszystkie = new WszystkieTytonieView(this);
		marka = new MarkaView(this);
		marki = new MarkiView(this);
		smak = new SmakView(this);
		smaki = new SmakiView(this);
		tytoñ = new TytoñView(this);
		nowytytoñ = new NowyTytoñView();
		NowyTytonPresenter nowytytonpresenter = new NowyTytonPresenter(this,
				nowytytoñ);
				
	}
	
	public void zmieñStronê(Strona strona) {
		contentPane.removeAll();
		contentPane.invalidate();
		switch (strona) {
			case KALENDARZ :
				contentPane.add(kalendarz);
				break;
			case MENUG£ÓWNE :
				contentPane.add(menu);
				break;
			case SHISHABARY :
				contentPane.add(shishabary);
				break;
			case TYTONIE :
				contentPane.add(tytonie);
				break;
			case WYDATKI :
				contentPane.add(wydatki);
				break;
			case WSZYSTKIE :
				contentPane.add(wszystkie);
				break;
			case MARKA :
				contentPane.add(marka);
				break;
			case MARKI :
				contentPane.add(marki);
				break;
			case SMAK :
				contentPane.add(smak);
				break;
			case SMAKI :
				contentPane.add(smaki);
				break;
			case TYTOÑ :
				contentPane.add(tytoñ);
				break;
			case NOWYTYTOÑ :
				contentPane.add(nowytytoñ);
			default :
				break;
		}
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public DBHandler getDbhandler() {
		return dbhandler;
	}
}
