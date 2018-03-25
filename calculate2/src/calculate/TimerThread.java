package calculate;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


<<<<<<< HEAD
/*public class TimerThread extends Thread {	 
=======
/*public class TimerThread extends Thread {	
>>>>>>> 64dc3123e1f25e964ad5fcbadb67cfee6ecaa7f2
	int time = 1;	boolean isRun = true;
	@Override	public void run() {	
		while(isRun){			
			try {
				
				System.out.print(time+"   ");
				time++;
				
				Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
			}
	}
}*/

public class TimerThread extends JFrame implements Runnable{
	 private JFrame frame;
	 private JPanel timePanel;
	 private JLabel timeLabel;
	 private JLabel displayArea;
	 private String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	 private int ONE_SECOND = 1000;
	 int time = 1;	boolean isRun = true; 
	 
	 public TimerThread()
	 {
	 timePanel = new JPanel();
	 timeLabel = new JLabel("您本次用时：");
	 displayArea = new JLabel();
	  
	 timePanel.add(timeLabel);
	 timePanel.add(displayArea);
	 this.add(timePanel);
	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 this.setBounds(800, 100, 200, 80);
	 }
	 
	 public void run()
	 {
		 while(isRun){	
		 try {
			
			 displayArea.setText(+time+"s");
				time++;
				
				Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
			}
	 }
<<<<<<< HEAD
	 
=======
>>>>>>> 64dc3123e1f25e964ad5fcbadb67cfee6ecaa7f2
	 }

	  

	