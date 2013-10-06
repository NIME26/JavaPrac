package utils;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 
 * @author Emin
 * @version 1.0.0
 *
 */
public class DatumGC {
	
	private String[] monthNames = {"januari","februari","maart","april","mei","juni",
			"juli","augustus","september","oktober","november","december"};
	private GregorianCalendar gregCal;
    
	// Constructors
	/**
	 * Default constuctor
	 */
	public DatumGC()throws IllegalArgumentException{
		gregCal = new GregorianCalendar();
	}
	
	/**
	 * Constructor with 1 param
	 * 
	 * @param date
	 */
	public DatumGC(Date date)throws IllegalArgumentException{
		gregCal = new GregorianCalendar();
		gregCal.setTime(date);
	}
    
	/**
	 * Constructor with 3 params
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public DatumGC(int year,int month,int day)throws IllegalArgumentException{
		gregCal = new GregorianCalendar(year,month-1,day);
	}
	
	/**
	 * Constructor with String param
	 * 
	 * @param string
	 */
	public DatumGC(String string)throws IllegalArgumentException{
		Scanner s = new Scanner(string);
		s.useDelimiter("\\s*/\\s*");
		int d = s.nextInt();
		int m = s.nextInt();
		int y = s.nextInt();
		s.close();
		
		if (String.valueOf(d).length() != 1 && String.valueOf(d).length() != 2)throw new IllegalArgumentException ("Dag is fout ingevuld");
		if (String.valueOf(m).length() != 2)throw new IllegalArgumentException ("Maand is fout ingevuld");
		if (String.valueOf(y).length() != 4)throw new IllegalArgumentException ("Jaar is fout ingevuld");
		
		gregCal = new GregorianCalendar(y,m-1,d);
	}
    
	// Selectors
	/**
	 * @return GregorianCalendar
	 */
	public GregorianCalendar getGregCal() {
		return gregCal;
	}
	
	/**
	 * Return String with date in American format
	 * 
	 * @return
	 */
	public String getDateInAmericanFormat() {
		return String.format("%d/%d/%d",
				gregCal.get(Calendar.YEAR),gregCal.get(Calendar.MONTH) + 1,
				gregCal.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * Return String with date in European format
	 * 
	 * @return
	 */
	public String getDateInEuropeanFormat() {
		return String.format("%d/%d/%d",
				gregCal.get(Calendar.DAY_OF_MONTH),gregCal.get(Calendar.MONTH) + 1,
				gregCal.get(Calendar.YEAR));
	}
	
	// Modifiers
	/**
	 * Set GregorianCalendar
	 * 
	 * @param gregCal
	 */
	public void setGregCal(GregorianCalendar gregCal) {
		int[] month31 = {1,3,5,7,8,10,12};
		int[] month30 = {4,6,9,11};
		
		if (gregCal.get(Calendar.YEAR) < 0 || gregCal.get(Calendar.YEAR) > 9999)throw new IllegalArgumentException("Jaar verkeerd!");;
		if (gregCal.get(Calendar.MONTH) < 1 || gregCal.get(Calendar.MONTH) > 12)throw new IllegalArgumentException("Maand verkeerd!");;
		
		for (int a : month31) {
			if (gregCal.get(Calendar.MONTH) == a) {
				if (gregCal.get(Calendar.DAY_OF_MONTH) < 1 || gregCal.get(Calendar.DAY_OF_MONTH) > 31)throw new IllegalArgumentException("Dag verkeerd!");
			}
		}
		
		for (int a : month30) {
			if (gregCal.get(Calendar.MONTH) == a) {
				if (gregCal.get(Calendar.DAY_OF_MONTH) < 1 || gregCal.get(Calendar.DAY_OF_MONTH) > 30)throw new IllegalArgumentException("Dag verkeerd!");
			}
		}
		
		if (gregCal.get(Calendar.MONTH) == 2) {
			if (gregCal.isLeapYear(gregCal.get(Calendar.YEAR))){
				if (gregCal.get(Calendar.DAY_OF_MONTH) < 1 || gregCal.get(Calendar.DAY_OF_MONTH) > 29)throw new IllegalArgumentException("Dag verkeerd!");
			}
			else {
				if (gregCal.get(Calendar.DAY_OF_MONTH) < 1 || gregCal.get(Calendar.DAY_OF_MONTH) > 28)throw new IllegalArgumentException("Dag verkeerd!");
			}
		}
		
		this.gregCal = gregCal;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %d",
				gregCal.get(Calendar.DAY_OF_MONTH), monthNames[gregCal.get(Calendar.MONTH)],
				gregCal.get(Calendar.YEAR));
	}
	/**
	 * Determines whether a date is smaller than current date object
	 * 
	 * @param d
	 * @return
	 */
	public boolean lessThan(Date d) {
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(d);
		if (g.getTimeInMillis() < gregCal.getTimeInMillis())
			return true;
		return false;
	}
	
	/**
	 * Difference in years between 2 dates
	 * 
	 * @param d
	 * @return
	 */
	public int differenceInYears(Date d) {
		GregorianCalendar g = new GregorianCalendar();
		
		// Set time based on Millis
		g.setTimeInMillis(Math.abs(gregCal.getTimeInMillis() - d.getTime()));
		return g.get(Calendar.YEAR) - 1970;
	}
	
	/**
	 * Difference in months between 2 dates
	 * 
	 * @param d
	 * @return
	 */
	public int differenceInMonths(Date d) {
		GregorianCalendar g = new GregorianCalendar();
		
		// Set time based on Millis
		g.setTimeInMillis(Math.abs(gregCal.getTimeInMillis() - d.getTime()));
		return ((g.get(Calendar.YEAR) - 1970) * 12) + g.get(Calendar.MONTH);
	}
	
	/**
	 * Difference in days between 2 dates
	 * 
	 * @param d
	 * @return
	 */
	public int differenceInDays(Date d) {
		// Difference in millis between 2 dates
		long diff = Math.abs(gregCal.getTimeInMillis() - d.getTime());
		
		// Correction in days count
		int c = 0;
		if (gregCal.getTimeInMillis() > d.getTime())
			++c;
		else
			--c;
		return (int)(Math.round(diff / (24.0 * 60 * 60 * 1000)) + c);
	}
	/**
	 * Increase or decrease date by number of days
	 * 
	 * @param days
	 */
	public void changeDate(int days) {
		long currentMillis = gregCal.getTimeInMillis();
		long daysMillis = 86400000L * days;
		gregCal.setTimeInMillis(currentMillis + daysMillis);
	}
	
	/**
	 * Returns new Date object equal to original object increased or decreased by number of days
	 * 
	 * @param days
	 * @return
	 */
	public Date changeToNewDate(int days) {
		Date d = new Date();
		d.setTime(gregCal.getTimeInMillis() + (86400000L * days));
		return d;
	}
}
