package vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import types.TypesStable;
import types.TypesTournament;
import vue.component.DataJPanel;
import vue.component.RendererStable;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Stables extends DataJPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5774382066208287732L;
	private JLabel lblTitle;
	private JPanel panelAllStables;
	private List<RendererStable> allRenderer;
	
	private void createStableInfo() {
		panelAllStables.removeAll();
		HashMap<Integer, TypesStable> map = MasterFrame.getInstance().getUser().getData().getStables();
        allRenderer = new LinkedList<RendererStable>();
        
        panelAllStables.setLayout(new GridLayout(0, 1));
        
        Iterator<TypesStable> ite = map.values().iterator();
        int cmp=0;
		while (ite.hasNext()) {
			TypesStable t = ite.next();
			RendererStable rend = new RendererStable(t,cmp);
			panelAllStables.add(rend);
			allRenderer.add(rend);
			cmp++;
		}
       
	}
	
	/**
	 * Create the panel.
	 */
	public Stables() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		lblTitle = new JLabel();
		lblTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblTitle.setForeground(MasterFrame.COLOR_TEXT);
		lblTitle.setText("Liste des écuries");
		lblTitle.setFont(new Font("Cambria", Font.BOLD, 40));
		lblTitle.setBorder(null);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblTitle);
		panelAllStables = new JPanel();
		createStableInfo();
		JScrollPane scrollPaneStableList = new JScrollPane(panelAllStables);
		scrollPaneStableList.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		scrollPaneStableList.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelContent.add(scrollPaneStableList, BorderLayout.CENTER);
		scrollPaneStableList.getVerticalScrollBar().setUnitIncrement(16);

	}

	@Override
	public void dataUpdate() {
		createStableInfo();
		revalidate();
		validate();
	}
	
	public RendererStable getRenderer(int id) {
		return allRenderer.get(id);
	}

}
