package pl.grm.sm.desktop;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.initWindow();

	}

	private void initWindow() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Desktop okno = new Desktop();
				okno.setVisible(true);
			}
		});

	}

}
