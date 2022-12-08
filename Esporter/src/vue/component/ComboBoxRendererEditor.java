package vue.component;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import vue.MasterFrame;

public class ComboBoxRendererEditor extends BasicComboBoxEditor {
	private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private Object selectedItem;

    public ComboBoxRendererEditor() {
        
        label.setOpaque(false);
        label.setFont(new Font("Cambria", Font.BOLD, 12));
        label.setForeground(MasterFrame.COULEUR_TEXTE);
         
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
        panel.add(label);
        panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
    }
    
    public Component getEditorComponent() {
        return this.panel;
    }
     
    public Object getItem() {
        return "[" + this.selectedItem.toString() + "]";
    }
     
    public void setItem(Object item) {
        this.selectedItem = item;
        label.setText(item.toString());
    }
}
