import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window 
{
	private static String var1; 
	private static String var2;
	private static String var3; 

	public static String getVar1()
	{
		return var1; 
	}
	
	public static String getVar2()
	{
		return var2; 
	}
	
	public static String getVar3()
	{
		return var3; 
	}
	
    public static void run() throws IOException 
    {
        JFrame inputFrame = new JFrame();
        inputFrame.setSize(550, 500);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.setLocation(450, 250);

        Container container = inputFrame.getContentPane();
        container.setLayout(new FlowLayout());

        JTextField textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100, 25));
        
        JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(100, 25));
        
        JTextField textField3 = new JTextField();
        textField3.setPreferredSize(new Dimension(100, 25));
       
        //JLabel label = new JLabel("Enter your data.");
        
        JLabel time = new JLabel("Time:");
        JLabel beta = new JLabel("Beta:");
        JLabel gamma = new JLabel("Gamma:");
        
        String path = System.getProperty("user.dir") + "/src/SIR_model-2.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel modelequation = new JLabel(new ImageIcon(image));

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            { 
                var1 = textField1.getText();
                var2 = textField2.getText(); 
                var3 = textField3.getText(); 
                try {
					ImageToWindow.run(var1,var2,var3);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
            }
        }
        );
        
        container.add(time);
        container.add(textField1);
        container.add(beta);
        container.add(textField2);
        container.add(gamma);
        container.add(textField3);
        container.add(okButton);
        //container.add(label);
        container.add(modelequation);

        inputFrame.setVisible(true);
    }
}