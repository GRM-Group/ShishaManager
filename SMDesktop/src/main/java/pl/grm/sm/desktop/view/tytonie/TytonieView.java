package pl.grm.sm.desktop.view.tytonie;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import pl.grm.sm.desktop.Desktop;
import pl.grm.sm.desktop.Strona;
public class TytonieView extends JPanel {
	
	private Desktop desktop;
	
	public TytonieView(Desktop desktop) {
		setLayout(new BorderLayout());
		JPanel pierwszy = new JPanel();
		pierwszy.setLayout(new GridLayout(3, 1, 0, 0));
		add(pierwszy, BorderLayout.NORTH);
		JPanel drugi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) drugi.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(drugi, BorderLayout.SOUTH);
		this.desktop = desktop;
		JButton wszystkie = new JButton("Wszystkie");
		wszystkie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.WSZYSTKIE);
			}
		});
		pierwszy.add(wszystkie);
		JButton marki = new JButton("Marki");
		marki.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.MARKI);
			}
		});
		pierwszy.add(marki);
		JButton smaki = new JButton("Smaki");
		smaki.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.SMAKI);
			}
		});
		pierwszy.add(smaki);
		JButton dodaj = new JButton("Dodaj tyto�");
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.NOWYTYTON);
			}
		});
		pierwszy.add(dodaj);
		JButton powrot = new JButton("<-");
		powrot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.MENUGLOWNE);
			}
		});
		drugi.add(powrot);
	}
}
