import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageToWindow 
{
    static void run(String time, String beta, String gamma) throws IOException, InterruptedException 
    {
        DiseaseSimulation d = new DiseaseSimulation(Integer.parseInt(time),Double.parseDouble(beta),Double.parseDouble(gamma));
        d.runSim();
        JLabel label = d.getGraph();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(label);
        f.pack();
        f.setLocation(400,200);
        f.setVisible(true);
    }
}