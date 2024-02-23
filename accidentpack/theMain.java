package accidentpack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import accidentpack.theArrayList.myObj;

public class theMain {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		ArrayList<myObj> myReport = theArrayList.readCSV("accidents_small_sample.csv");
		long end = System.currentTimeMillis();
		System.out.printf("%05.2f seconds to read the reports\n",(double)((end - start) / 1000.0));
		//test output to make sure it is oldest first
		System.out.println(myReport.get(0).getStartTime().toString());
		System.out.println(myReport.get(1).getStartTime().toString());
		System.out.println(myReport.get(2).getStartTime().toString());
		
		//output to work on using input
//		Scanner userIn = new Scanner(System.in);
//		String filePath = args[0];
//		String state = args[1];
//		long start = System.currentTimeMillis();
//		long end = System.currentTimeMillis();
//		System.out.printf("%05.2f xx seconds to read the reports for %s\n",(double)((end - start) / 1000.0), state);
	}

}
