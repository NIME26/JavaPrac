package utils;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author Emin
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
	public DatumGC(){
		gregCal = new GregorianCalendar();
	}
	
	/**
	 * Constructor with 1 param
	 * 
	 * @param date
	 */
	public DatumGC(Date date){
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
	public DatumGC(int year,int month,int day){
		gregCal = new GregorianCalendar(year,month,day);
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
		this.gregCal = gregCal;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %d",
				gregCal.get(Calendar.DAY_OF_MONTH), monthNames[gregCal.get(Calendar.MONTH)],
				gregCal.get(Calendar.YEAR));
	}
}
