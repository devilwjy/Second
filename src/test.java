import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class test {

	 public static void main(String[] args){
	    	
	    	Scanner x=new Scanner(System.in);
	    	System.out.print("请输入一个整数：");
	    	int number=x.nextInt();
	    	int writer=0;
	    	try {
                //如果文件存在，则追加内容；如果文件不存在，则创建文件
                File file = new File("result.txt");
                FileWriter fw = new FileWriter(file, true);

                PrintWriter pw = new PrintWriter(fw);
                
                if(writer==0)
                {
                    pw.println("201571030128");
                    writer=1;
                }
	    	       
	     
	    	System.out.println("201571030128");
	    	for(int i=1;i<=number;i++)
	    	{
	    		
	    		//随机生成数
	    		Random rd=new Random();
	    		int data1=rd.nextInt(100)+1;
	    		int data2=rd.nextInt(100)+1;
	    		int data3=rd.nextInt(100)+1;
	    		//随机生成运算符
	    		String[] operator={"*","/","+","-"};
	    		Random r=new Random();
	    		int num1=r.nextInt(4);
	    		int num2=r.nextInt(4);
	    		String str=data1+operator[num1]+data2+operator[num2]+data3;
	    		//System.out.println(str);
	    		int result;
	 
		    	if(operator[num1]=="+")
		    	{
		    		if(operator[num2]=="+")
		    		{
		    			result=data1+data2+data3;
		    			System.out.println(str+"="+result);
		    			pw.println(str+"="+result);
		    		}
		    		else if(operator[num2]=="-")
		    		{
		    			if(data1+data2>=data3)
		    			{
		    				result=data1+data2-data3;
			    			System.out.println(str+"="+result);
			    			pw.println(str+"="+result);
		    			}
		    			else{
		    				number++;
		    			}
		    		}
		    		else if(operator[num2]=="*")
		    		{
		    			result=data1+data2*data3;
		    			System.out.println(str+"="+result);
		    			pw.println(str+"="+result);
		    		}
		    		else
		    		{
		    			if(data2%data3==0 && data3!=0)
		    			{
		    				result=data1+data2/data3;
			    			System.out.println(str+"="+result);
			    			pw.println(str+"="+result);
		    			}
		    			else{
		    				number++;
		    			}
		    		}
		    	}
		    	
		    	else if(operator[num1]=="-")
		    	{
		    		if(operator[num2]=="+")
		    		{
		    			if(data1>=data2)
		    			{
		    				result=data1-data2+data3;
		    				System.out.println(str+"="+result);
		    				pw.println(str+"="+result);
		    			}
		    			else{
		    				number++;
		    			}
		    		}
		    		else if(operator[num2]=="-")
		    		{
		    			if(data1>=data2)
		    			{
		    				if(data1-data2>=data3)
		    				{
		    					result=data1-data2-data3;
			    				System.out.println(str+"="+result);
			    				pw.println(str+"="+result);
		    				}
		    				else{
		    					number++;
		    				}
		    			}
		    			else{
		    				number++;
		    			}
		    		}
		    		else if(operator[num2]=="*")
		    		{
		    			if(data1>=data2*data3)
		    			{
		    				result=data1-data2*data3;
		    				System.out.println(str+"="+result);
		    				pw.println(str+"="+result);
		    			}
		    			else{
		    				number++;
		    			}
		    		}
		    		else{
		    			if(data2%data3==0 && data3!=0)
		    			{
		    				if(data1>=data2/data3)
		    				{
		    					result=data1-data2/data3;
			    				System.out.println(str+"="+result);
			    				pw.println(str+"="+result);
		    				}
		    				else{
		    					number++;
		    				}
		    			}
		    			else{
		    				number++;
		    			}
		    		} 		
		    	}
		    	
		    	else if(operator[num1]=="*")
		    	{
		    		if(operator[num2]=="+")
		    		{
		    			result=data1*data2+data3;
	    				System.out.println(str+"="+result);
	    				pw.println(str+"="+result);
		    		}
		    		else if(operator[num2]=="-"){
		    			if(data1*data2>=data3)
		    			{
		    				result=data1*data2-data3;
		    				System.out.println(str+"="+result);
		    				pw.println(str+"="+result);
		    			}
		    			else{
		    				number++;
		    			}
		    		}
		    		else if(operator[num2]=="*")
		    		{
		    			result=data1*data2*data3;
	    				System.out.println(str+"="+result);
	    				pw.println(str+"="+result);
		    		}
		    		else{
		    			int result1=data1*data2;
		    			if(result1%data3==0 && data3!=0)
		    			{
		    				result=data1*data2/data3;
		    				System.out.println(str+"="+result);
		    				pw.println(str+"="+result);
		    			}
		    			else{
		    				number++;
		    			}
		    		}
		    	}
		    	//第一个运算符为“/”
		    	else{
		    		if(data1%data2==0 && data2!=0)//判断data1能否被data2整除,且除数data2不能为0
		    		{
		    			if(operator[num2]=="+")//乘除的优先级高于加减，所以可以顺着往下计算
		    			{
		    				result=data1/data2+data3;
		    				System.out.println(str+"="+result);
		    				pw.println(str+"="+result);
		    			}
		    			else if(operator[num2]=="-")
		    			{
		    				if(data1/data2>=data3)//判断data1/data2的商是否大于data3
		    				{
		    					result=data1/data2-data3;
			    				System.out.println(str+"="+result);
			    				pw.println(str+"="+result);
		    				}
		    				else{
		    					number++;//不符合条件就将表达式的个数加1，进行下一个表达式的计算
		    				}
		    			}
		    			else if(operator[num2]=="*")
		    			{
		    				result=data1/data2*data3;
		    				System.out.println(str+"="+result);
		    				pw.println(str+"="+result);
		    			}
		    			else{
		    				int result1=data1/data2;
		    				if(result1%data3==0 && data3!=0)//判断data1/data2的商能否整除data3，且data3不能为0
		    				{
		    					result=data1/data2/data3;
			    				System.out.println(str+"="+result);
			    				pw.println(str+"="+result);
		    				}
		    				else{
		    					number++;
		    				}
		    			}
		    		}
		    		else{
		    			number++;
		    		}
		    	}
		   
	    	}
	    	
	    	 pw.flush();
             pw.close();
             fw.close();
         } catch (IOException e1) {
             e1.printStackTrace();
         }
     }
	    	
	    
	    
	 
}
	    	
