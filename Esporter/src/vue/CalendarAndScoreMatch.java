package vue;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JScrollPane;

import types.TypesMatch;
import types.TypesPool;
import types.TypesTournament;
import vue.component.DataJPanel;
import vue.component.RendererProgramMatch;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

public class CalendarAndScoreMatch extends DataJPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private TypesTournament tournament;
    private JPanel panelContainerRenderers;
    private ArrayList<RendererProgramMatch> renderers;

    public void createProgramMatchList() {
    	panelContainerRenderers.removeAll();
    	renderers = new ArrayList<>();
        ArrayList<TypesPool> poolList = tournament.getPool();
        List<TypesMatch> matchList = new ArrayList<>();
        
        for(TypesPool pool : poolList) {
            for(TypesMatch match: pool.getMatchs()) {
                matchList.add(match);
            }
        }
        matchList = matchList.stream().sorted().collect(Collectors.toList());
        int id=0;
        for (TypesMatch match: matchList){
        	System.out.println(match.getTeam1()+" VS "+match.getTeam2());
        	RendererProgramMatch rpm = new RendererProgramMatch(match,id);
            panelContainerRenderers.add(rpm);
            renderers.add(rpm);
            id ++;
        }
        this.revalidate();
    }

    public CalendarAndScoreMatch(TypesTournament tournament) {
        this.tournament = tournament;
        setLayout(new BorderLayout(0, 0));

        //JPanel panel_1 = new JPanel();
        //add(panel_1);
        //panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

       
        
        JPanel panelContainerHeader = new JPanel();
        add(panelContainerHeader, BorderLayout.NORTH);
        panelContainerHeader.setLayout(new BorderLayout(0, 0));
        
        JLabel lblTournament = new JLabel("Calendrier des matchs");
        lblTournament.setPreferredSize(new Dimension(55, 100));
        lblTournament.setHorizontalAlignment(SwingConstants.CENTER);
        lblTournament.setFont(new Font("Cambria", Font.BOLD, 35));
        panelContainerHeader.add(lblTournament);
        
        JPanel panelContainerJScroll = new JPanel();
        panelContainerJScroll.setBorder(new EmptyBorder(50, 100, 50, 100));
        add(panelContainerJScroll, BorderLayout.CENTER);
        
      
        panelContainerRenderers = new JPanel();
        createProgramMatchList();
        JScrollPane scrollPane = new JScrollPane(panelContainerRenderers);
        scrollPane.setBorder(null);
        panelContainerRenderers.setLayout(new GridLayout(0, 1, 0, 0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        panelContainerJScroll.setLayout(new BorderLayout(0, 0));
        panelContainerJScroll.add(scrollPane);
    }
    
    public RendererProgramMatch getRenderer(int id) {
    	return this.renderers.get(id);
    }

	@Override
	public void dataUpdate() {
		createProgramMatchList();
		revalidate();
		repaint();
		
	}

}