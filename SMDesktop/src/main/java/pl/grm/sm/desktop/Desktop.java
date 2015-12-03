package pl.grm.sm.desktop;

import java.io.IOException;

import javax.swing.*;

import pl.grm.sm.core.DBHandler;
import pl.grm.sm.core.sql.DBConnection;
import pl.grm.sm.desktop.presenters.NowyTytonPresenter;
import pl.grm.sm.desktop.view.*;
import pl.grm.sm.desktop.view.tytonie.*;
public class Desktop extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuGlowneView menu;
	private KalendarzView kalendarz;
	private TytonieView tytonie;
	private ShishaBaryView shishabary;
	private WydatkiView wydatki;
	private WszystkieTytonieView wszystkie;
	private MarkaView marka;
	private MarkiView marki;
	private SmakView smak;
	private SmakiView smaki;
	private TytonView tyton;
	private NowyTytonView nowytyton;
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
		setContentPane(contentPane); // <---- ustawia contentPane jako g��wny
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
		zmienStrone(Strona.MENUGLOWNE);
	}
	
	private void stworzStrony() {
		menu = new MenuGlowneView(this);
		kalendarz = new KalendarzView(this);
		shishabary = new ShishaBaryView(this);
		tytonie = new TytonieView(this);
		wydatki = new WydatkiView(this);
		wszystkie = new WszystkieTytonieView(this);
		marka = new MarkaView(this);
		marki = new MarkiView(this);
		smak = new SmakView(this);
		smaki = new SmakiView(this);
		tyton = new TytonView(this);
		nowytyton = new NowyTytonView();
		NowyTytonPresenter nowytytonpresenter = new NowyTytonPresenter(this,
 nowytyton);
				
	}
	
	public void zmienStrone(Strona strona) {
		contentPane.removeAll();
		contentPane.invalidate();
		switch (strona) {
			case KALENDARZ :
				contentPane.add(kalendarz);
				break;
			case MENUGLOWNE :
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
			case TYTON :
				contentPane.add(tyton);
				break;
			case NOWYTYTON :
				contentPane.add(nowytyton);
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
