import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.font.*;
import javax.imageio.*;

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
		 * Add foreground:
		 */
		ForegroundComponent foreground = new ForegroundComponent();
		add(foreground);	
		
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
}

class ForegroundComponent extends JComponent {
	public ForegroundComponent() {
		try {
			image = ImageIO.read(new File("port-tester.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		String message = "Port Tester";
		
		/*
		 * Set font:
		 */
		Font headerFont = new Font("Helvetica", Font.PLAIN, 24);
		g2.setFont(headerFont);
		
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = headerFont.getStringBounds(message, context);
		
		int messageX = (int) (getWidth() - bounds.getWidth()) / 2;
		
		g2.drawString(message, messageX, MESSAGE_Y);
		
		/*
		 * Set image:
		 */
		if (image == null) return;
		
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		
		int imageX = (int) (getWidth() - imageWidth) / 2;
		
		g2.drawImage(image, imageX, IMAGE_Y, null);
	}
	
	public static final int MESSAGE_Y = 50;
	public static final int IMAGE_Y = 60;
	private Image image;
}