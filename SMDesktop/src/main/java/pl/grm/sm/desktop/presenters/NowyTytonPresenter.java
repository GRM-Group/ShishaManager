package pl.grm.sm.desktop.presenters;

import javax.swing.JTextField;

import pl.grm.sm.desktop.Desktop;
import pl.grm.sm.desktop.view.tytonie.NowyTytoñView;

public class NowyTytonPresenter {

	private Desktop desktop;
	private NowyTytoñView view;
	
	public NowyTytonPresenter(Desktop desktop, NowyTytoñView nowytytoñ) {
		this.desktop = desktop;
		this.view = nowytytoñ;
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
		}
 else
			System.out.println("wpisz poprawnie");
		
		return null;
	}
	
}
