package affichage;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestPane extends JPanel {

    private String text = "Hello";
    private JLabel label;
    private int charIndex = 0;

    public TestPane(String str) {
    	this.text = str;
        setLayout(new GridBagLayout());
        label = new JLabel();
        add(label);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String labelText = label.getText();
                labelText += text.charAt(charIndex);
                label.setText(labelText);
                charIndex++;
                if (charIndex >= text.length()) {
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
}
