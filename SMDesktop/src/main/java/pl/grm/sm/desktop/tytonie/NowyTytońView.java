package pl.grm.sm.desktop.tytonie;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pl.grm.sm.desktop.Desktop;
import pl.grm.sm.desktop.Strona;
public class NowyTytoñView extends JPanel {
	
	private Desktop desktop;
	private JTextField tfSmak;
	private JTextField textField;
	private JTextField tfCena;
	
	public NowyTytoñView(Desktop desktop) {
		setLayout(new BorderLayout());
		setSize(300, 350);
		JPanel pierwszy = new JPanel();
		pierwszy.setLayout(new GridLayout(0, 1, 0, 0));
		add(pierwszy, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		pierwszy.add(panel_1);
		
		JLabel label = new JLabel("Marka:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		panel_1.add(textField);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		pierwszy.add(panel_2);
		
		JLabel lblSmak = new JLabel("Smak:");
		panel_2.add(lblSmak);
		
		tfSmak = new JTextField();
		panel_2.add(tfSmak);
		tfSmak.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		pierwszy.add(panel_3);
		
		JLabel lblOcenaDymu = new JLabel("Ocena dymu:");
		panel_3.add(lblOcenaDymu);
		
		JSlider sliderDym = new JSlider();
		sliderDym.setMinorTickSpacing(1);
		sliderDym.setSnapToTicks(true);
		sliderDym.setMinimum(1);
		sliderDym.setMaximum(11);
		sliderDym.setPaintLabels(true);
		sliderDym.setPaintTicks(true);
		Hashtable<Integer, JLabel> labels = new Hashtable();
		labels.put(1, new JLabel("1"));
		labels.put(2, new JLabel("1+"));
		labels.put(3, new JLabel("2"));
		labels.put(4, new JLabel("2+"));
		labels.put(5, new JLabel("3"));
		labels.put(6, new JLabel("3+"));
		labels.put(7, new JLabel("4"));
		labels.put(8, new JLabel("4+"));
		labels.put(9, new JLabel("5"));
		labels.put(10, new JLabel("5+"));
		labels.put(11, new JLabel("6"));
		
		sliderDym.setLabelTable(labels);
		panel_3.add(sliderDym);
		

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		pierwszy.add(panel_4);
		
		JLabel lblOcenaSmaku = new JLabel("Ocena smaku:");
		panel_4.add(lblOcenaSmaku);
		
		JSlider sliderSmak = new JSlider();
		sliderSmak.setMinorTickSpacing(1);
		sliderSmak.setMinimum(1);
		sliderSmak.setMaximum(11);
		sliderSmak.setSnapToTicks(true);
		sliderSmak.setPaintTicks(true);
		sliderSmak.setPaintLabels(true);
		
		sliderSmak.setLabelTable(labels);
		panel_4.add(sliderSmak);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		pierwszy.add(panel_5);
		
		JLabel lblCzasPalenia = new JLabel("Czas palenia:");
		panel_5.add(lblCzasPalenia);
		
		JSlider sliderCzas = new JSlider();
		panel_5.add(sliderCzas);
		sliderCzas.setToolTipText("Czas palenia");
		sliderCzas.setPaintLabels(true);
		sliderCzas.setPaintTicks(true);
		sliderCzas.setSnapToTicks(true);
		sliderCzas.setMinorTickSpacing(15);
		sliderCzas.setMaximum(240);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_6.getLayout();
		pierwszy.add(panel_6);
		
		JLabel lblCena = new JLabel("Cena /50g:");
		panel_6.add(lblCena);
		
		tfCena = new JTextField();
		panel_6.add(tfCena);
		tfCena.setColumns(10);
		
		JPanel drugi = new JPanel();
		add(drugi, BorderLayout.SOUTH);
		this.desktop = desktop;
		
		GridBagLayout gbl_drugi = new GridBagLayout();
		gbl_drugi.columnWidths = new int[]{60, 90, 60};
		gbl_drugi.rowHeights = new int[]{23};
		gbl_drugi.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_drugi.rowWeights = new double[]{0.0};
		drugi.setLayout(gbl_drugi);
		
		JButton anuluj = new JButton("Anuluj");
		anuluj.addActionListener(e -> desktop.zmieñStronê(Strona.TYTONIE));
		GridBagConstraints gbc_anuluj = new GridBagConstraints();
		gbc_anuluj.anchor = GridBagConstraints.WEST;
		gbc_anuluj.gridx = 0;
		gbc_anuluj.gridy = 0;
		drugi.add(anuluj, gbc_anuluj);
		
		JButton zatw = new JButton("ZatwierdŸ");
		GridBagConstraints gbc_zatw = new GridBagConstraints();
		gbc_zatw.anchor = GridBagConstraints.EAST;
		gbc_zatw.gridx = 2;
		gbc_zatw.gridy = 0;
		drugi.add(zatw, gbc_zatw);
	}
}
