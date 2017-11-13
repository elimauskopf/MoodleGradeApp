import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DiseaseSimulation {
	private int time;
	private double beta;
	private double gamma;

	public DiseaseSimulation(int t, double b, double g) {
		time = t;
		beta = b;
		gamma = g;
	}

	public void runSim() throws IOException, InterruptedException {
		String address = System.getProperty("user.dir") + "/src";
		String file_name = " diseasemodel.R";
		String prog = " Rscript ";
		String add = "\"" + address + "\"";
		String path_to_file = "cd " + add + " && " + prog + " " + file_name + " " + time + " " + beta + " " + gamma
				+ " " + add;
		System.out.println(path_to_file);
		String[] run_it = { "cmd.exe ", "/c", path_to_file };
		ProcessBuilder builder = new ProcessBuilder(run_it);
		builder.redirectErrorStream(true);
		Process p = builder.start();
		File f = new File(address + "/output.png");
		while(!f.exists()) { 
		    Thread.sleep(1);
		}
	}

	public JLabel getGraph() throws IOException {
		//JLabel label = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src"+"output.png"));
		String path = System.getProperty("user.dir") + "/src/output.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
		return label;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		DiseaseSimulation d = new DiseaseSimulation(70, 1.4, 0.3);
		d.runSim();
		d.getGraph();
	}

}
