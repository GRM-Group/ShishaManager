package pl.grm.sm.desktop.view.tytonie;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pl.grm.sm.core.DBHandler;
import pl.grm.sm.desktop.Desktop;
import pl.grm.sm.desktop.Strona;
public class MarkiView extends JPanel {
	
	private Desktop desktop;
	
	public MarkiView(Desktop desktop) {
		setLayout(new BorderLayout());
		JPanel pierwszy = new JPanel();
		pierwszy.setLayout(new GridLayout(3, 1, 0, 0));
		add(pierwszy, BorderLayout.NORTH);
		JPanel drugi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) drugi.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(drugi, BorderLayout.SOUTH);
		this.desktop = desktop;
		DBHandler db = desktop.getDbhandler();
		// db.execute().
		JButton powrót = new JButton("<-");
		powrót.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.zmieñStronê(Strona.TYTONIE);
			}
		});
		drugi.add(powrót);
	}
}
