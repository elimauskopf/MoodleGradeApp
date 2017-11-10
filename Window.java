import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	
    public static void run() 
    {
        JFrame inputFrame = new JFrame();
        inputFrame.setSize(400, 200);
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
       
        JLabel label = new JLabel("Enter your data.");

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            { 
                var1 = textField1.getText();
                var2 = textField2.getText(); 
                var3 = textField3.getText(); 
                try {
					ImageToWindow.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
            }
        }
        );

        container.add(textField1);
        container.add(textField2);
        container.add(textField3);
        container.add(okButton);
        container.add(label);

        inputFrame.setVisible(true);
    }
}