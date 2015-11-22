import javax.swing.*;
import java.awt.*;

/*
 * PortTester - GUI network tool for testing TCP-ports
 * @author Andrew Dorokhov
 */
public class PortTester {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PortTesterFrame frame = new PortTesterFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class PortTesterFrame extends JFrame {
	
	public PortTesterFrame() {
		setTitle("Port Tester");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
		setLocationByPlatform(true);
		
		/*
		 * Add header component:
		 */
		HeaderComponent header = new HeaderComponent();
		add(header);
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
}

class HeaderComponent extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		/*
		 * Set font:
		 */
		Font headerFont = new Font("Helvetica", Font.PLAIN, 24);
		g2.setFont(headerFont);
		
		g2.drawString("Port Tester", MESSAGE_X, MESSAGE_Y);
	}
	
	public static final int MESSAGE_X = 100;
	public static final int MESSAGE_Y = 50;
}