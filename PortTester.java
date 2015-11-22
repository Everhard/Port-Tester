import javax.swing.JFrame;

/*
 * PortTester - GUI network tool for testing TCP-ports
 * @author Andrew Dorokhov
 */
public class PortTester {
	public static void main(String[] args) {
		PortTesterFrame frame = new PortTesterFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Port Tester");
		frame.setVisible(true);
	}
}

class PortTesterFrame extends JFrame {
	
	public PortTesterFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
		setLocationByPlatform(true);
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
}