package pl.grm.sm.desktop.presenters;

import javax.swing.JSlider;
import javax.swing.JTextArea;
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
		JTextField tfCena = this.view.getTfCena();
		JSlider jsOcenaSmak = this.view.getSliderSmak();
		JSlider jsOcenaDym = this.view.getSliderDym();
		JSlider jsCzas = this.view.getSliderCzas();
		JTextArea taOpis = this.view.getTaOpis();
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
				if (!dbhand.execute().tytonIstnieje(tfMarka.getText(),
						tfSmak.getText())) {
					dbhand.execute().dodajTyton(tfMarka.getText(),
							tfSmak.getText());
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
