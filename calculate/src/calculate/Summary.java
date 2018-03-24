package calculate;

/*
 * this is grade summary 
 */

import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class Summary extends JFrame
{
	 static ArrayList<String> integer = new ArrayList<String>();
 	static ArrayList<String> IntAnswer = new ArrayList<String>();
 	static ArrayList<String> fraction = new ArrayList<String>();
 	static ArrayList<String> FraAnswer = new ArrayList<String>();

	 public static final int DEFAULT_WIDTH = 500;
	 public static final int DEFAULT_HEIGHT = 500;
	 
	 private JButton button1;
	 private JButton button2;
	 
	 private JLabel label1;
	 private JTextArea textArea1;
	 calculate cal = new calculate();
	 public  Summary(int grade,final ArrayList<String> Calculate,final ArrayList<String> Answer,
		    final BufferedWriter out,int[] Error,final int n,final String c11,final String c22)
	 {
		 setTitle("得分情况");
	    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	    setLocationByPlatform(true);//可以自行设置窗口位置 
	     
	     label1 = new JLabel("你得了" +grade+"分 ， 正确答案显示如下:",JLabel.LEFT);
	     label1.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 18));
	     label1.setBounds(200, 50, 300,45);
	     add(label1);
	     
	       button1 = new JButton("再来一轮");
	       button1.setBounds(800, 200, 100,25);
	       add(button1);
	       
	       button2 = new JButton("总结");
	       button2.setBounds(800, 400, 100,25);
	       add(button2);
	     
	     textArea1 = new JTextArea();
	     textArea1.setColumns(21);
	     textArea1.setRows(21);
	     textArea1.setBounds(200, 100, 400,400);
	     add(textArea1);
	     int i =0;
	     
	     for(i=0;i<20;i++)
	    	 if((Error[i])!=-1)
	    	 {
				textArea1.append("第"+(Error[i]+1)+"道题："+Calculate.get(Error[i])+Answer.get(Error[i])+"\n");
	    	 }
	     JPanel pan = new JPanel();
	     
	     add(pan);
	     
	    
	 button1.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent  event)
			{
				//ArrayList<Competitor> competition = new ArrayList<Competitor>();

		    	int i,result;
		         // n=in.nextInt();
		        int value;
		        for(i=0;i<20;i++){
		            int num1=(int)(Math.random()*100);//随机生成一个0-100的整数
		            int num2=(int)(Math.random()*100);//随机生成一个0-100的整数
		            int num3=(int)(Math.random()*100);//随机生成一个0-100的整数
		            int num4=(int)(Math.random()*100);//随机生成一个0-100的整数
		            int num5=(int)(Math.random()*100);//随机生成一个0-100的整数
		            int numn=(int)(Math.random()*3);//随机生成一个0-3的整数,0表示3个运算数，1表示4个运算数，2表示5个运算数,3表示分数计算
		            switch(numn)
		            {
		               case 0:
		            	    String s=cal.threenum(num1,num2,num3);
		            	    value = cal.jisuan(s);
		            	    if(value==-1)
		            	    	i--;
		            	    else
		            	    {
		            	    	try {
									out.write(s+value+"\r\n");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} // \r\n即为换行   
		            	    integer.add(s);
		            	    
		            	    IntAnswer.add(value+"");
		            	    }
		            	    
		            	    
		            	   // System.out.println(s+value);
		            	    break;
		               case 1:
		            	   s=cal.fournum(num1,num2,num3,num4);
		            	   //System.out.println(s);
		           	    value = cal.jisuan(s);
		           	    if(value==-1)
		           	    	i--;
		           	    else
		           	    {
		        	    	try {
								out.write(s+value+"\r\n");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} // \r\n即为换行   
		        	    integer.add(s);
		        	    
		        	    IntAnswer.add(value+"");
		        	    }
		           	    break;
		               case 2:
		            	   s=cal.fivenum(num1,num2,num3,num4,num5);
		            	   //System.out.println(s);
		           	    value = cal.jisuan(s);
		           	    if(value==-1)
		           	    	i--;
		           	    else
		           	 {
		        	    	try {
								out.write(s+value+"\r\n");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} // \r\n即为换行   
		        	    integer.add(s);
		        	    
		        	    IntAnswer.add(value+"");
		        	    }
		           	    break;
		            }
		        }
		        int num1,num2,num3;
	            for(i=0;i<20;i++){
	            num1=1+(int)(Math.random()*10);//随机生成一个0-100的整数
	            num2=1+(int)(Math.random()*10);//随机生成一个0-100的整数
	            num3=1+(int)(Math.random()*10);//随机生成一个0-100的整数
	    	   int M,Z;
	           int x1,x2,x3;
	               x1=1+(int)(Math.random()*num1);//生成一个比分母num1小的分子，实现真分数
	               x2=1+(int)(Math.random()*num2);//生成一个比分母num2小的分子，实现真分数
	               x3=1+(int)(Math.random()*num3);//生成一个比分母num3小的分子，实现真分数
	                   Z=x1*num2*num3+x2*num1*num3+x3*num1*num2;
	                   M=num1*num2*num3;
	                   String d=cal.simplification(Z,M);
	                   String s=x1+"/"+num1+"+"+x2+"/"+num2+"+"+x3+"/"+num3+"=";
	                   fraction.add(s);
	                   FraAnswer.add(d);
	            }
	                  // System.out.println(s);
	            try {
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	              setVisible(false); 
		          Select frame = new Select(integer,fraction,IntAnswer,FraAnswer,out,n,c11,c22);
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	               frame.setResizable(false);//窗口的大小 不可变 
	               frame.setLocationRelativeTo(null);//使窗口显示 在中央 
			        	
			  }
					 
				
				
		 });
	
   /* button2.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent  event)
			{
				    
					 if(event.getSource()==button2)
			           {
						setVisible(false); 
			          	//final String name11 = new String(name.getText());
			           //final String number11 = new String(number.getText());
			          	
						Grade ss	= new Grade(fraction,FraAnswer,c1,c2);
			            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			        	ss.setVisible(true);
			        	setLocationRelativeTo(null);
			        	
			           }
					
				}
		 });*/	
	 }
}
	 

