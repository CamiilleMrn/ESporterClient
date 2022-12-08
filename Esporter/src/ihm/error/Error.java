package ihm.error;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ihm.MasterFrame;
import types.exception.ExceptionInvalidPermission;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

public class Error extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1996527475653186651L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Error dialog = new Error(new ExceptionInvalidPermission("Vous ne possedez pas la permission d'effectuer ceci"));
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
		Point p = MasterFrame.getInstance().getFrameCenter();
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
			JLabel lblTitle = new JLabel("Error : "+e.getClass().getSimpleName());
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblTitle, BorderLayout.NORTH);
		}
		{
			JLabel lblContent = new JLabel(e.getMessage());
			lblContent.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblContent, BorderLayout.CENTER);
		}
		{
			JPanel panelButton = new JPanel();
			panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelButton, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.setActionCommand("OK");
				panelButton.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				panelButton.add(btnCancel);
			}
		}
	}

}
