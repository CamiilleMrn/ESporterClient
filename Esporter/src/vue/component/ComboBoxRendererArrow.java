package vue.component;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import vue.MasterFrame;

public class ComboBoxRendererArrow {
	
	public static class MyComboBoxUI extends BasicComboBoxUI {
        @Override
        protected void installDefaults() {
            super.installDefaults();
            LookAndFeel.uninstallBorder(comboBox); //remove the LAF border for both button and label of combo box.
        }

        @Override
        protected JButton createArrowButton() {
            //Feel free to play with the colors:
            final Color background = MasterFrame.COULEUR_MASTER;     //Default is UIManager.getColor("ComboBox.buttonBackground").
            final Color pressedButtonBorderColor = null; //Default is UIManager.getColor("ComboBox.buttonShadow"). The color of the border of the button, while it is pressed.
            final Color triangle = Color.WHITE;               //Default is UIManager.getColor("ComboBox.buttonDarkShadow"). The color of the triangle.
            final Color highlight = background;               //Default is UIManager.getColor("ComboBox.buttonHighlight"). Another color to show the button as highlighted.
            final JButton button = new BasicArrowButton(BasicArrowButton.SOUTH, background, pressedButtonBorderColor, triangle, highlight);
            button.setName("ComboBox.arrowButton"); //Mandatory, as per BasicComboBoxUI#createArrowButton().
            return button;
        }
        
    }
	
	public static ComponentUI createUI(JComponent c) {
    	return new MyComboBoxUI();
    }
	

}
