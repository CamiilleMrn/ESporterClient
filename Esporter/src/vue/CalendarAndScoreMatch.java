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
import vue.component.RendererProgramMatch;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class CalendarAndScoreMatch extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private TypesTournament tournament;
    private JPanel panelContainerRenderers;

    public void createProgramMatchList() {
        ArrayList<TypesPool> poolList = tournament.getPool();
        List<TypesMatch> matchList = new ArrayList<>();
        for(TypesPool pool : poolList) {
            System.out.println("poule : "+pool);
            for(TypesMatch match: pool.getMatchs()) {
                System.out.println("match : "+match);
                matchList.add(match);
            }
        }
        matchList = matchList.stream().sorted().collect(Collectors.toList());
        for (TypesMatch match: matchList){
            panelContainerRenderers.add(new RendererProgramMatch(match));
        }
        panelContainerRenderers.setLayout(new GridLayout(0, 1, 0, 10));
    }

    public CalendarAndScoreMatch(TypesTournament tournament) {
        this.tournament = tournament;
        setLayout(new BorderLayout(0, 0));


        JLabel lblTournament = new JLabel(tournament.getName());
        lblTournament.setHorizontalAlignment(SwingConstants.CENTER);
        lblTournament.setPreferredSize(new Dimension(lblTournament.getPreferredSize().width, 100));
        lblTournament.setFont(new Font("Cambria", Font.BOLD, 25));
        add(lblTournament, BorderLayout.NORTH);

        //JPanel panel_1 = new JPanel();
        //add(panel_1);
        //panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

        panelContainerRenderers = new JPanel();
        createProgramMatchList();
        JScrollPane scrollPane = new JScrollPane(panelContainerRenderers);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        add(scrollPane, BorderLayout.CENTER);
    }

}