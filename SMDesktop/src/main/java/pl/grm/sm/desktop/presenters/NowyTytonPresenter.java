package pl.grm.sm.desktop.presenters;

import javax.swing.JTextField;

import pl.grm.sm.core.DBHandler;
import pl.grm.sm.desktop.Desktop;
import pl.grm.sm.desktop.view.tytonie.NowyTytonView;

public class NowyTytonPresenter {

	private Desktop desktop;
	private NowyTytonView view;
	
	public NowyTytonPresenter(Desktop desktop, NowyTytonView nowytyton) {
		this.desktop = desktop;
		this.view = nowytyton;
		this.view.setNowytytonpresenter(this);
		
	}
	
	public Desktop getDesktop() {
		return desktop;
	}
	
	public Object dodajTyton() {
		JTextField tfMarka = this.view.getTfMarka();
		JTextField tfSmak = this.view.getTfSmak();
		if (tfMarka.getText() != null && tfMarka.getText().trim().length() > 3
				&& tfSmak.getText() != null
				&& tfSmak.getText().trim().length() > 3) {
			System.out.println("el doopa");
			DBHandler dbhand = desktop.getDbhandler();
			try {
				if (!dbhand.execute().markaIstnieje(tfMarka.getText())) {
					dbhand.execute().dodajMarke(tfMarka.getText());
				}
				if (!dbhand.execute().smakIstnieje(tfSmak.getText())) {
					dbhand.execute().dodajSmak(tfSmak.getText());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 else
			System.out.println("wpisz poprawnie");
		
		return null;
	}
	
}
