package vue.referee;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import types.TypesMatch;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controleur.Controler;
import controleur.State;

public class SetScore extends JDialog{
	
	private JRadioButton rdbTeam1;
	private JRadioButton rdbTeam2;
	private TypesMatch match;

	public SetScore(TypesMatch match) {
		this.match = match;
		
		Controler.getInstance().openDialog(this, State.ADD_SCORE);
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				Controler.getInstance().closeDialog();
				dispose();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		
		
		
		setSize(new Dimension(400,200));

        // add radio buttons to a ButtonGroup
        final ButtonGroup group = new ButtonGroup();

        getContentPane().setLayout(new GridLayout(0, 1));
        JLabel label = new JLabel("Choisir le gagnant du match");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(label);
        
        JPanel panelMain = new JPanel();
        getContentPane().add(panelMain);
        
        rdbTeam1 = new JRadioButton(Controler.getInstance().getData().getTeams().get(match.getTeam1()).getStable().getNickname());
        group.add(rdbTeam1);
        panelMain.add(rdbTeam1);
        
        rdbTeam2 = new JRadioButton(Controler.getInstance().getData().getTeams().get(match.getTeam2()).getStable().getNickname());
        group.add(rdbTeam2);
        panelMain.add(rdbTeam2);
        
        JPanel panelValidate = new JPanel();
        getContentPane().add(panelValidate);
        
        JButton btnCancel = new JButton("Annuler");
        btnCancel.addActionListener(Controler.getInstance());
        btnCancel.setActionCommand("ADD_SCORE_CANCEL");
        panelValidate.add(btnCancel);
        
        JButton btnValidate = new JButton("Valider");
        btnValidate.addActionListener(Controler.getInstance());
        btnValidate.setActionCommand("ADD_SCORE_VALIDATE");
        panelValidate.add(btnValidate);
	}
	
	public JRadioButton getRdbTeam1() {
		return rdbTeam1;
	}
	
	public JRadioButton getRdbTeam2() {
		return rdbTeam2;
	}
	
	public TypesMatch getMatch() {
		return match;
	}
	
	
	

}
