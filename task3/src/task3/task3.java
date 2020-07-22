package task3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class task3 {

	public static void main(String[] args) throws ParseException {
		ArrayList<String> d = new ArrayList<String>();
	    String line = "";
	    String m = args[0];
	    double erp = 0;
	    double erm = 0;
	    double vp = 0;
	    double vm = 0;
	    double nvp = 0;
	    double nvm = 0;
	    double v = 0;
	    double n = 0;
	    double up = 0;
	    double um = 0;
		try {
		int t = 0;
		File file = new File(m);
		FileReader fr = new FileReader(file);
	    BufferedReader reader = new BufferedReader(fr);
	    line = reader.readLine();
	    while (line != null) {
            line = reader.readLine();
            if (t == 0) 
            {
            	v = Double.parseDouble(line);
            }
            else if (t == 1)
            {
            	n = Double.parseDouble(line);
            }
            if (t > 1)
            {
            	d.add(line);
            }
            t++;
            
        }
        reader.close();;
	    }
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String s;
		Date min = new SimpleDateFormat("y-M-d H:m:s.S").parse(args[1]);
		Date max = new SimpleDateFormat("y-M-d H:m:s.S").parse(args[2]);
	    for (int i = 0; i < d.size() - 1; i ++)
	    {
	    	s = d.get(i);
	    	int a = s.indexOf("op");
	    	int b = s.indexOf("up");
	    	double a1;
	    	double b1;
	    	s = s.substring(0, 21);
	    	s = s.replace("T", " ");
	    	Date date = new SimpleDateFormat("y-M-d H:m:s.S").parse(s);
	    	if(min.getTime() < date.getTime() & max.getTime() > date.getTime()  )
	    	{
	    		if (a > 0)
	    		{
	    			a1 = Double.parseDouble(s.substring(a + 2, a + 4));
	    			if(n - a > 0) 
	    			{
	    				n -= a;
	    				vm += a;
	    				um++;
	    			}
	    			else 
	    			{
	    				erm++;
	    				nvm += a;
	    			}
	    		}
	    		else 
	    		{
	    			b1 = Double.parseDouble(s.substring(a + 2, a + 4));
	    			if(n + a < v) 
	    			{
	    				n += a;
	    				vp +=a;
	    				up++;
	    			}
	    			else 
	    			{
	    				erp++;
	    				nvp += a;
	    			}
	    		}
	    	}
	    }
	    System.out.println(up+erp);
	    System.out.println(erp / ((up+erp)/100));
	    System.out.println(vp);
	    System.out.println(nvp);
	    System.out.println(um+erm);
	    System.out.println(erm / ((um+erm)/100));
	    System.out.println(vm);
	    System.out.println(nvm);
	}

}
