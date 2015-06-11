package com.codexion.utilities;

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ReglaDeTres provides a simple GUI to perform cross-multiplications by means 
 * of the Rule Of Three
 * @author Lucas Vieites <lucas@codexion.com>
 * @see http://en.wikipedia.org/wiki/Rule_of_three_%28mathematics%29#Rule_of_Three
 *
 */
public class ReglaDeTres extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField txtUno = null;

	private JLabel lblSi = null;

	private JLabel lblEs = null;

	private JTextField txtDos = null;

	private JLabel lblEntonces = null;

	private JTextField txtResultado = null;

	private JLabel txtXEs = null;

	private JButton btnCalcular = null;

	private JButton btnByCodexioncom = null;

	private JTextField txtTres = null;

	/**
	 * txtUno will contain numerator of the first term 
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUno() {
		if (txtUno == null) {
			txtUno = new JTextField();
			txtUno.setBounds(new Rectangle(70, 15, 70, 22));
			txtUno.setHorizontalAlignment(JTextField.RIGHT);
		}
		return txtUno;
	}

	/**
	 * txtDos will contain the denominator of the first term	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDos() {
		if (txtDos == null) {
			txtDos = new JTextField();
			txtDos.setLocation(new Point(210, 15));
			txtDos.setHorizontalAlignment(JTextField.RIGHT);
			txtDos.setSize(new Dimension(70, 22));
		}
		return txtDos;
	}

	/**
	 * txtTres will contain the numerator of the second term	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTres() {
		if (txtTres == null) {
			txtTres = new JTextField();
			txtTres.setHorizontalAlignment(JTextField.RIGHT);
			txtTres.setSize(new Dimension(70, 22));
			txtTres.setLocation(new Point(70, 48));
			txtTres.setActionCommand("calc");
			txtTres.addActionListener(this);
		}
		return txtTres;
	}

	/**
	 * txtResultado will contain the result of the operation	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtResultado() {
		if (txtResultado == null) {
			txtResultado = new JTextField();
			txtResultado.setHorizontalAlignment(JTextField.RIGHT);
			txtResultado.setLocation(new Point(210, 48));
			txtResultado.setSize(new Dimension(70, 22));
			txtResultado.setEditable(false);
		}
		return txtResultado;
	}

	/**
	 * btnCalcular is the button that fires the calculation	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton();
			btnCalcular.setBounds(new Rectangle(165, 81, 115, 26));
			btnCalcular.setText("Calcular");
			btnCalcular.setActionCommand("calc");
			btnCalcular.addActionListener(this);
		}
		return btnCalcular;
	}

	/**
	 * btnByCodexioncom is a vanity button that opens my web page	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnByCodexioncom() {
		if (btnByCodexioncom == null) {
			btnByCodexioncom = new JButton();
			btnByCodexioncom.setRolloverEnabled(false);
			btnByCodexioncom.setText("by codexion.com");
			btnByCodexioncom.setForeground(Color.BLUE);
			btnByCodexioncom.setFont(new Font(btnByCodexioncom.getFont().getName(),Font.ITALIC,btnByCodexioncom.getFont().getSize()-1));
			btnByCodexioncom.setBounds(15, 83, 125, 23);
			btnByCodexioncom.setActionCommand("web");
			btnByCodexioncom.addActionListener(this);
		}
		return btnByCodexioncom;
		
	}

	/**
	 * The main method of tjis class shows the GUI
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReglaDeTres thisClass = new ReglaDeTres();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public ReglaDeTres() {
		super();
		setPreferredSize(new Dimension(300, 150));
		setMaximumSize(new Dimension(800, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReglaDeTres.class.getResource("/com/codexion/utilities/resources/regladetres_16x16.png")));
		initialize();
		this.getRootPane().setDefaultButton(btnCalcular);
	}

	/**
	 * This method initializes the GUI
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 150);
		this.setContentPane(getJContentPane());
		this.setTitle("Regla de tres");
		// Pone la ventana en el centro de la pantalla
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-300)/2, (screenSize.height-150)/2, 300, 150);
		// Desactiva la capacidad de cambiar el tamaño de la ventana
		// y elimina el botón de maximizar
		this.setResizable(false);
	}

	/**
	 * This method initializes jContentPane and all the components inside it
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			txtXEs = new JLabel();
			txtXEs.setBounds(new Rectangle(165, 48, 31, 22));
			txtXEs.setText("es:");
			lblEntonces = new JLabel();
			lblEntonces.setBounds(new Rectangle(15, 50, 53, 19));
			lblEntonces.setText("entonces");
			lblEs = new JLabel();
			lblEs.setText("es:");
			lblEs.setSize(new Dimension(31, 22));
			lblEs.setLocation(new Point(165, 15));
			lblSi = new JLabel();
			lblSi.setBounds(new Rectangle(15, 15, 23, 22));
			lblSi.setText("Si");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtUno(), null);
			jContentPane.add(lblSi, null);
			jContentPane.add(lblEs, null);
			jContentPane.add(getTxtDos(), null);
			jContentPane.add(lblEntonces, null);
			jContentPane.add(getTxtResultado(), null);
			jContentPane.add(txtXEs, null);
			jContentPane.add(getBtnCalcular(), null);
			jContentPane.add(getTxtTres(), null);
			jContentPane.add(getBtnByCodexioncom(), null);
		}
		return jContentPane;
	}

	/**
	 * This is the ActionListener
	 * @param e the exception
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		String command = e.getActionCommand();
		if (command.equals("calc")) {
			NumberFormat nf = NumberFormat.getNumberInstance(new Locale("es", "ES"));
			//DecimalFormat df = new DecimalFormat("#.###.###.##0,00");
			DecimalFormat df = (DecimalFormat)nf;
			double primero = (double) Float.valueOf(txtUno.getText());
			double segundo = (double) Float.valueOf(txtDos.getText());
			double tercero = (double) Float.valueOf(txtTres.getText());
			int decimales = 2;
			double resultado;
			resultado = (segundo * tercero) / primero;
			resultado = Math.round(resultado * Math.pow(10,decimales)) / Math.pow(10,decimales);
			txtResultado.setText(df.format(resultado));
		} else if (command.equals("web")) {
			try {
				String url = "http://www.codexion.com";
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			} catch (java.io.IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
