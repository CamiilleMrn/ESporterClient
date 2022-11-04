package ihm.erreur;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ihm.MasterFrame;
import types.exception.InvalidPermission;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

public class Error extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Error dialog = new Error(new InvalidPermission("Vous ne possedez pas la permission d'effectuer ceci"));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Error(Exception e) {
		Point p = MasterFrame.getInstance().getCentre();
		p.move(getWidth()/2, getHeight()/2);
		setLocation(p);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel Titre = new JLabel("Error : "+e.getClass().getSimpleName());
			Titre.setFont(new Font("Tahoma", Font.BOLD, 19));
			Titre.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(Titre, BorderLayout.NORTH);
		}
		{
			JLabel Contenu = new JLabel(e.getMessage());
			Contenu.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(Contenu, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
