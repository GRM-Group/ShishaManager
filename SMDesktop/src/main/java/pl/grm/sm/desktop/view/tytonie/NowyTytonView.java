package pl.grm.sm.desktop.view.tytonie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pl.grm.sm.desktop.Strona;
import pl.grm.sm.desktop.presenters.NowyTytonPresenter;
public class NowyTytonView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel pierwszy;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel drugi;
	private JTextField tfSmak;
	private JTextField tfMarka;
	private JTextField tfCena;
	private NowyTytonPresenter nowytytonpresenter;
	private JButton zatw;
	private JTextArea taOpis;
	private JSlider sliderDym;
	private JSlider sliderSmak;
	private JSlider sliderCzas;
	
	public NowyTytonView() {
		setLayout(new BorderLayout());
		Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
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
		
		pierwszy = new JPanel();
		add(pierwszy, BorderLayout.CENTER);
		pierwszy.setLayout(new BoxLayout(pierwszy, BoxLayout.PAGE_AXIS));
		
		{
			panel_1 = new JPanel();
			pierwszy.add(panel_1);
		
			JLabel label = new JLabel("Marka:");
			label.setHorizontalAlignment(SwingConstants.LEFT);
			panel_1.add(label);
			
			tfMarka = new JTextField();
			tfMarka.setHorizontalAlignment(SwingConstants.LEFT);
			tfMarka.setColumns(10);
			panel_1.add(tfMarka);
		}
		{
			panel_2 = new JPanel();
			pierwszy.add(panel_2);
		
			JLabel lblSmak = new JLabel("Smak:");
			panel_2.add(lblSmak);
		
			tfSmak = new JTextField();
			tfSmak.setColumns(10);
			panel_2.add(tfSmak);
		}
		{
			panel_3 = new JPanel();
			FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
			flowLayout_2.setAlignment(FlowLayout.RIGHT);
			pierwszy.add(panel_3);
			
			JLabel lblOcenaDymu = new JLabel("Ocena dymu:");
			panel_3.add(lblOcenaDymu);
			
			sliderDym = new JSlider();
			sliderDym.setMinorTickSpacing(1);
			sliderDym.setSnapToTicks(true);
			sliderDym.setMinimum(1);
			sliderDym.setMaximum(11);
			sliderDym.setPaintLabels(true);
			sliderDym.setPaintTicks(true);
			sliderDym.setLabelTable(labels);
			panel_3.add(sliderDym);
		}

		{
			panel_4 = new JPanel();
			FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
			flowLayout_3.setAlignment(FlowLayout.RIGHT);
			pierwszy.add(panel_4);
			
			JLabel lblOcenaSmaku = new JLabel("Ocena smaku:");
			panel_4.add(lblOcenaSmaku);
			
			sliderSmak = new JSlider();
			sliderSmak.setMinorTickSpacing(1);
			sliderSmak.setMinimum(1);
			sliderSmak.setMaximum(11);
			sliderSmak.setSnapToTicks(true);
			sliderSmak.setPaintTicks(true);
			sliderSmak.setPaintLabels(true);
			sliderSmak.setLabelTable(labels);
			panel_4.add(sliderSmak);
		}
		{
			panel_5 = new JPanel();
			FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
			flowLayout_4.setAlignment(FlowLayout.RIGHT);
			pierwszy.add(panel_5);
			
			JLabel lblCzasPalenia = new JLabel("Czas palenia:");
			panel_5.add(lblCzasPalenia);
			
			sliderCzas = new JSlider();
			sliderCzas.setToolTipText("Czas palenia");
			sliderCzas.setPaintLabels(true);
			sliderCzas.setPaintTicks(true);
			sliderCzas.setSnapToTicks(true);
			sliderCzas.setMinorTickSpacing(20);
			sliderCzas.setMaximum(220);
			panel_5.add(sliderCzas);
		}
		{
			panel_6 = new JPanel();
			pierwszy.add(panel_6);
			
			JLabel lblCena = new JLabel("Cena /50g:");
			panel_6.add(lblCena);
			
			tfCena = new JTextField();
			tfCena.setColumns(10);
			panel_6.add(tfCena);
		}
		{
			panel_7 = new JPanel();
			pierwszy.add(panel_7);
			
			JLabel lblOpis = new JLabel("Opis:");
			panel_7.add(lblOpis);
			
			taOpis = new JTextArea();
			taOpis.setLineWrap(true);
			taOpis.setRows(10);
			taOpis.setColumns(20);
			taOpis.setMaximumSize(new Dimension(20, 10));
			panel_7.add(taOpis);
		}
		
		drugi = new JPanel();
		add(drugi, BorderLayout.SOUTH);
		

		GridBagLayout gbl_drugi = new GridBagLayout();
		gbl_drugi.columnWidths = new int[]{60, 90, 60};
		gbl_drugi.rowHeights = new int[]{23};
		gbl_drugi.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_drugi.rowWeights = new double[]{0.0};
		drugi.setLayout(gbl_drugi);
		
		JButton anuluj = new JButton("Anuluj");
		anuluj.addActionListener(e -> nowytytonpresenter.getDesktop()
.zmienStrone(Strona.TYTONIE));
		GridBagConstraints gbc_anuluj = new GridBagConstraints();
		gbc_anuluj.anchor = GridBagConstraints.WEST;
		gbc_anuluj.gridx = 0;
		gbc_anuluj.gridy = 0;
		drugi.add(anuluj, gbc_anuluj);
		
		zatw = new JButton("Zatwierdz");
		GridBagConstraints gbc_zatw = new GridBagConstraints();
		gbc_zatw.anchor = GridBagConstraints.EAST;
		gbc_zatw.gridx = 2;
		gbc_zatw.gridy = 0;
		drugi.add(zatw, gbc_zatw);
	
	}
	
	public JTextField getTfSmak() {
		return tfSmak;
	}
	
	public JTextField getTfMarka() {
		return tfMarka;
	}
	
	public JTextField getTfCena() {
		return tfCena;
	}
	
	public JTextArea getTaOpis() {
		return taOpis;
	}
	
	public JSlider getSliderDym() {
		return sliderDym;
	}
	
	public JSlider getSliderSmak() {
		return sliderSmak;
	}
	
	public JSlider getSliderCzas() {
		return sliderCzas;
	}
	
	public void setNowytytonpresenter(NowyTytonPresenter nowytytonpresenter) {
		this.nowytytonpresenter = nowytytonpresenter;
		zatw.addActionListener(e -> nowytytonpresenter.dodajTyton());
	}
}