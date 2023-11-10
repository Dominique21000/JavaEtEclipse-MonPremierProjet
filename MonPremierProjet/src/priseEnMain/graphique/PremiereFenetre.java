package priseEnMain.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;

public class PremiereFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremiereFenetre frame = new PremiereFenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PremiereFenetre() {
		setTitle("1ère fenêtre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PremiereFenetre.class.getResource("/priseEnMain/graphique/Yin_and_yang.svg.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenuFichier = new JMenu("Fichier");
		menuBar.add(mnMenuFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.setAction(action);
		mnMenuFichier.add(mntmQuitter);
		
		JMenu mnMenuClient = new JMenu("Client");
		menuBar.add(mnMenuClient);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnValider, "Vous avez saisi \"" + textField.getText() + "\"");
			}
		});
		btnValider.setBounds(178, 160, 89, 23);
		contentPane.add(btnValider);
		
		textField = new JTextField();
		textField.setBounds(104, 106, 278, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Saisissez un message");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 24, 414, 51);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
	}
	
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3097605980868331689L;
		public SwingAction() {
			putValue(NAME, "Quitter");
			putValue(SHORT_DESCRIPTION, "Fermer l'application");
			putValue(MNEMONIC_KEY, KeyEvent.VK_Q);  
		    putValue(ACCELERATOR_KEY,  
		                 KeyStroke.getKeyStroke(KeyEvent.VK_Q, 
		                 InputEvent.CTRL_DOWN_MASK)); 
		}
		public void actionPerformed(ActionEvent e) {
			dispose(); // permet de relâcher les ressources graphiques
		}
	}
}
