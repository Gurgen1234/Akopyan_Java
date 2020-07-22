package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2 {

	public static void main(String[] args) {
	ArrayList<Double> d = new ArrayList<Double>();
    String line = "";
	try {
	File file = new File(args[1]);
	FileReader fr = new FileReader(file);
    BufferedReader reader = new BufferedReader(fr);
    line = reader.readLine();
    reader.close();
    }
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	Pattern pat=Pattern.compile("[^e][0-9]+(.[0-9]+)?");
	Matcher matcher=pat.matcher(line.replace("[", " "));
	while (matcher.find()) {
	    d.add(Double.parseDouble(matcher.group().replace(" ", "")));
	    
	}
	
	double as1 = S(d.get(0),d.get(1),d.get(2),d.get(3),d.get(4),d.get(5));
	double as2 = S(d.get(3),d.get(4),d.get(5),d.get(6),d.get(7),d.get(8));
	double as3 = S(d.get(6),d.get(7),d.get(8),d.get(0),d.get(1),d.get(2));
	double bs1 = S(d.get(9),d.get(10),d.get(11),d.get(12),d.get(13),d.get(14));
	double bs2 = S(d.get(12),d.get(13),d.get(14),d.get(15),d.get(16),d.get(17));
	double bs3 = S(d.get(15),d.get(16),d.get(17),d.get(9),d.get(10),d.get(11));
	System.out.println(as1);
	System.out.println(as2);
	System.out.println(as3);
	System.out.println(bs1);
	System.out.println(bs2);
	System.out.println(bs3);
	System.out.println(as2/bs2);
	if(as1 / bs1 == as2 / bs2 & as2 / bs2 == as3 / bs3 |  as1 / bs2 == as2 / bs3 & as2 / bs3 == as3 / bs1 | as1 / bs3 == as2 / bs1 & as2 / bs1 == as3 / bs2)
	{
		System.out.println("Да");
	}
	else
	{
		System.out.println("Нет");
	}
}
public static double S (double a, double b, double c, double d, double e, double f ) {
	double g = Math.sqrt(Math.pow((d - a),2) + Math.pow((e - b),2) + Math.pow((f - c),2));
	
		return g;
	
}


}