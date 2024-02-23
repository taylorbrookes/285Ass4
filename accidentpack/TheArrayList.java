package accidentpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Create an ArrayList of objects.
 * Objects have attributes StartTime, County, State, and Severity.
 * Attributes are LocalDateTime, String, String, int respectively.
 * Finish by sorting the ArrayList by StartTime newest first.
 * 
 * @author Taylor Brookes
 * @version 23 February 2024
 */

public class theArrayList {
	
	/**
	 * The custom object class with getters.
	 */
	public static class myObj {
		//initialize parameters
		LocalDateTime StartTime;
		String County;
		String State;
		int Severity;
		//constructor
		public myObj(String data) {
			String[] inData = data.split(",");
			StartTime = timeTryCatch(inData[2]);
			County = inData[6];
			State = inData[7];
			Severity = (int)Double.parseDouble(inData[1]);
		}
		//getters to use in sort method
		public LocalDateTime getStartTime() {
			return this.StartTime;
		}
		public String getCounty() {
			return this.County;
		}
		public String getState() {
			return this.State;
		}
		public int getSeverity() {
			return this.Severity;
		}
	}
	
	/**
	 * Takes in CSV file name and returns sorted ArrayList by startTime.
	 * @param filePath the CSV file name
	 * @return sorted ArrayList by startTime.
	 * @throws IOException
	 */
	public static ArrayList<myObj> readCSV(String filePath) throws IOException {
		//initialize report
		ArrayList<myObj> reports = new ArrayList<myObj>();
		//input reader
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		//checks if hit last line
        String line = null;
        //skips category row
        boolean firstLineRead = false; 
        while ((line = reader.readLine()) != null) {
            if (!firstLineRead) {
                firstLineRead = true;
                continue;
            }
            //use ArrayList .add() and create an obj from the input str
            reports.add(new myObj(line));
        }
        reader.close();
        //sort the ArrayList
        sortArrayList(reports);
		return reports;
	}
	
	/**
	 * Sorts the ArrayList.
	 * @param theArrayList the ArrayList to be sorted
	 */
	private static void sortArrayList(ArrayList<myObj> theArrayList) {
		//custom sort method
		//https://stackoverflow.com/questions/40517977/sorting-a-list-with-stream-sorted-in-java
		theArrayList.sort((o1,o2) -> o2.getStartTime().compareTo(o1.getStartTime()));
	}
	
	/**
	 * Creates a LocalDateTime value from a string value to be used
	 * for comparison in sortArrayList and returns it.
	 * @param theTime the input string to be converted to LocalDateTime
	 * @return the LocalDateTime version of the input String
	 */
	public static LocalDateTime timeTryCatch(String theTime) {
		//the most common used formatter in startTime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//extra formats found
		DateTimeFormatter oneFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnnnnn");
		DateTimeFormatter twoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnn");
		//initialize because won't compile without
		LocalDateTime outputDate;
		try {
			//if it's SEC with no decimal
			outputDate = LocalDateTime.parse(theTime, formatter);
		} catch (Exception e) {
			try {
				//if it's SEC.nano
				outputDate = LocalDateTime.parse(theTime, oneFormatter);
			} catch (Exception f) {
				//if it's SEC.micro
				outputDate = LocalDateTime.parse(theTime, twoFormatter);
			}
		}
		return outputDate;
	}
}
