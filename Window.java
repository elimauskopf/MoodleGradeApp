import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window {
	private static String var1;
	private static String var2;
	private static String var3;

	public static String getVar1() {
		return var1;
	}

	public static String getVar2() {
		return var2;
	}

	public static String getVar3() {
		return var3;
	}

	private static JLabel createImage(String filename) throws IOException {
		String path = System.getProperty("user.dir") + filename;
		File file = new File(path);
		BufferedImage image = ImageIO.read(file);
		JLabel label = new JLabel(new ImageIcon(image));
		return label;
	}

	public static void run() throws IOException {
		JFrame inputFrame = new JFrame();
		inputFrame.setSize(850, 700);
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputFrame.setLocation(450, 250);

		UIManager.put("OptionPane.minimumSize", new Dimension(500, 200));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 20));
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 20));
		Object[] options = { "Disease", "Fashion" };
		int mode = JOptionPane.showOptionDialog(inputFrame, "Select Mode", "Select Mode", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		boolean fashion;
		if (mode == JOptionPane.YES_OPTION) {
			fashion = false;
		} else {
			fashion = true;
		}

		Container container = inputFrame.getContentPane();
		container.setLayout(new FlowLayout());

		JTextField textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(100, 25));

		JTextField textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(100, 25));

		JTextField textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension(100, 25));

		JLabel labeldisease = createImage("/src/beta_gamma-1.png");
		JLabel labelfashion = createImage("/src/fashionBeta.png");

		JLabel label;
		if (fashion == false) {
			label = labeldisease;
		} else {
			label = labelfashion;
		}

		JLabel time = createImage("/src/T.png");
		JLabel beta = createImage("/src/Beta.png");
		JLabel gamma = createImage("/src/Gamma.png");

		JLabel modelequation = createImage("/src/SIR_model-2.png");

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var1 = textField1.getText();
				var2 = textField2.getText();
				var3 = textField3.getText();
				try {
					ImageToWindow.run(var1, var2, var3, fashion);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});

		container.add(time);
		container.add(textField1);
		container.add(beta);
		container.add(textField2);
		container.add(gamma);
		container.add(textField3);
		container.add(okButton);
		container.add(label);
		container.add(modelequation);

		inputFrame.setVisible(true);
	}
}