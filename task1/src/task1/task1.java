package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class task1 {

	public static void main(String[] args) {
		ArrayList<Integer> d = new ArrayList<Integer>(); 
		
	    int min = 0; 
		try {
		File file = new File(args[0]);
		FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            d.add(Integer.parseInt(line));
            line = reader.readLine();
            
        }
        reader.close();
        }
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		double sum = 0;
		int a = 0;
		for(int i = 0; i < d.size() - 1;i++)
		{
			sum += d.get(i);
			min = d.get(i);
			int t = 0;
			for(int j = i + 1; j < d.size();j++)
			{
				
				if (d.get(j) < min) 
				{
					a = j;
					min = d.get(j);
					t++;
				}
			}
			if(t != 0) {
			d.set(a, d.get(i));
			d.set(i, min);
			}
		}
		sum += d.get(d.size() - 1);
		double e = Math.abs(0.9 * (d.size() - 1) + 1);
		double e1 = e - e % 1;
		double e2 = e % 1;
		double proc = d.get((int)e1 - 1) + e2 * (d.get((int)e1) - d.get((int)e1 - 1));  
		double sred = sum / d.size();
		double min1;
		double max1;
		if (proc < sred)
		{
			min1 = proc;
			max1 = sred;
		}
		else
		{
			min1 = sred;
			max1 = proc;
		}
		double sum1 = 0;
		for(int c : d)
        {
        	if(c >= min1 & c <= max1 )
        	{
        		sum1 += c;
        	}
        }
		System.out.println(sum1);
}
}
