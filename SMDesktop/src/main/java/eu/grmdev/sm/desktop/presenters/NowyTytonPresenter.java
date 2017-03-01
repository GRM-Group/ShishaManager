package eu.grmdev.sm.desktop.presenters;

import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import eu.grmdev.sm.core.DBHandler;
import eu.grmdev.sm.desktop.Desktop;
import eu.grmdev.sm.desktop.view.tytonie.NowyTytonView;

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
	
	public void dodajTyton() {
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
			String cenaString = tfCena.getText();
			double cena;
			try {
				cena = Double.parseDouble(cenaString);
			} catch (NumberFormatException e) {
				cena = 0;
				e.printStackTrace();
			}
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
				if (!dbhand.execute().daneTytoniuIstnieje(tfMarka.getText(), tfSmak.getText())) {
					dbhand.execute().dodajDaneTytoniu(tfMarka.getText(), tfSmak.getText(), jsOcenaDym.getValue(), jsOcenaSmak.getValue(), jsCzas.getValue(), (cena == 0 ? null : cena),
							taOpis.getText());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 else {
			System.out.println("wpisz poprawnie");
		}
		return;
	}
	
}
