package ihm.error;

import javax.swing.JProgressBar;
import javax.swing.plaf.ComponentUI;

public class JCircleProgressBar extends JProgressBar {

    /**
	 * 
	 */
	private static final long serialVersionUID = 431754621039465148L;

	public void setUI(ComponentUI newUI) {
        super.setUI(new ProgressCircleUI());
    }
}