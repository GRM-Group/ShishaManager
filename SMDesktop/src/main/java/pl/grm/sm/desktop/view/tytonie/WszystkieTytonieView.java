package pl.grm.sm.desktop.view.tytonie;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import pl.grm.sm.desktop.Desktop;
import pl.grm.sm.desktop.Strona;
public class WszystkieTytonieView extends JPanel {
	
	private Desktop desktop;
	
	public WszystkieTytonieView(Desktop desktop) {
		setLayout(new BorderLayout());
		JPanel pierwszy = new JPanel();
		pierwszy.setLayout(new GridLayout(3, 1, 0, 0));
		add(pierwszy, BorderLayout.NORTH);
		JPanel drugi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) drugi.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(drugi, BorderLayout.SOUTH);
		this.desktop = desktop;
		JButton powrot = new JButton("<-");
		powrot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmienStrone(Strona.TYTONIE);
			}
		});
		drugi.add(powrot);
	}
}
