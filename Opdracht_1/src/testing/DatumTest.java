package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import utils.DatumGC;
/*
 * 
 * @author: Jo
 * 
 */
public class DatumTest {

	public static DatumGC Tester;
	
	
	@BeforeTest
	public static void Test_Setup()
	{
		Tester= new DatumGC();
	}
	
	/*@AfterTest
	public static void Test_Cleanup()
	{
		//code schrijven voor leeg te maken van de test classe
	}*/
	
	/**
	 * Just to see the dates as they are returned
	 */
	@Test 
	public void GC_today()
	{
		DatumGC test1=new DatumGC();
		Object A=test1.getDateInAmericanFormat();
		Object B=test1.getDateInEuropeanFormat();
		System.out.println("Test 1 - Give Today's date:");
		System.out.println(A); //American format
		System.out.println(B); //European format
	}
	
	/**
	 * Test to see if we can get the same date back from DatumGC
	 */
	@Test 
	public void GC_Compare_To_Today()
	{
		DatumGC test2=new DatumGC();
		String Date_Test_Today=GetTodaysDateInAmerican();
		String Date_Test= test2.getDateInAmericanFormat();
		System.out.print("Test 2 - Compare to today: Fail if no next line for this test\n");
		assertEquals(Date_Test_Today,Date_Test);
		System.out.println("Test 2 - succesfull, the dates are the same");
	}
	
	/**
	 * Test with wrong date
	 * 
	 * Returns nothing if test succeeds
	 * 
	 * @throws Exception
	 */
	@Test
	public void GC_Compare_To_Wrong_Date() throws Exception{
	 String a = Tester.getDateInAmericanFormat();
	 String b = getDateInAmericanFormat(2013,1,1);
	 if (a==b)
	 {
		 b=getDateInAmericanFormat(2013,1,2);
	 }
	 assertEquals(a,b);
	 
	 System.out.println("Test 3: Test failed, the dates are the same");
	}
	
	/**
	 * 
	 * Differences with Dates: testing
	 * 
	 */
	
	@Test
	public void lessThan_Test_Todays_Value() throws NullPointerException {
		Date d=getDateValue_Random();
		Boolean a=false;
		try{
		a=Tester.lessThan(d);
		}
		catch(Exception e){
			System.out.println("Test2 lessThan has failed:");
			System.out.println(e);
		}
		
	}
	
	@Test
	public void differenceInYears_Test_Correct(){
		int a=2000;
		int b=12;
		int c=13;
		getDateValue(a,b,c);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Return String with date in American format
	 * 
	 * @return
	 */
	public String getDateInAmericanFormat(int Year, int Month, int Day) {
		return String.format("%d/%d/%d",
				Year,Month,Day);
	}
	public String getDateInAmericanFormat(Calendar A) {
		return String.format("%d/%d/%d",
				A,A,A);
	}
	/**
	 * Return String with date in European format
	 * 
	 * @return
	 */
	public String getDateInEuropeanFormat(int Year, int Month, int Day) {
		return String.format("%d/%d/%d",
				Year,Month,Day);
	}
	public String getDateInEuropeanFormat(Calendar A) {
		return String.format("%d/%d/%d",
				A,A,A);
	}
	/**
	 * Return today's date in the American or European format
	 * @return 
	 * 
	 * @return
	 */
	public String GetTodaysDateInAmerican(){
		Calendar Now= Calendar.getInstance();
		int Month= Now.get(Calendar.MONTH)+1;
		int Year= Now.get(Calendar.YEAR);
		int Day= Now.get(Calendar.DAY_OF_MONTH);
		return getDateInAmericanFormat(Year,Month,Day);
		
	}
	public String GetTodaysDateInEuropean(){
		Calendar Now= Calendar.getInstance();
		int Month= Now.get(Calendar.MONTH)+1;
		int Year= Now.get(Calendar.YEAR);
		int Day= Now.get(Calendar.DAY_OF_MONTH);
		return getDateInEuropeanFormat(Year,Month,Day);
		
	}
	
	/**
	 * 
	 * Create new date to test with
	 * 
	 */
	
	public void getDateValue(int Year, int Month, int Day) {
		System.out.println("Test nieuwe datum");
		String startDateString = Integer.toString(Year)+"-"+Integer.toString(Month)+"-"+Integer.toString(Day);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
        Date startDate=null;
        String newDateString = null;
        try 
        {
            startDate = df.parse(startDateString);
            newDateString = df.format(startDate);
            System.out.println(startDate);
        } catch (ParseException e) 
        {
            e.printStackTrace();
        }
    }
	
	/**
	 * 
	 * Get Random date
	 * 
	 */
	public Date getDateValue_Random() {
		int Year= ((int) (Math.random()*(2050+1)));
		int Month=(int) (Math.random()*12);
		int Day=1;
		int schrikkeljaar;
		switch (Month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				Day=(int) (Math.random()*31);
				break;
			case 2:
				schrikkeljaar=Year;
				while(schrikkeljaar>400){
					schrikkeljaar-=400;
				}	
				if (schrikkeljaar==400){
					Day=(int)(Math.random()*29);
				}else{
					schrikkeljaar=Year;
					while(schrikkeljaar>100){
						schrikkeljaar-=100;
					}
					if(schrikkeljaar==100){
						Day=(int)(Math.random()*28);
					}else{
						schrikkeljaar=Year;
						while(schrikkeljaar>4){
							schrikkeljaar-=4;
						}
						if(schrikkeljaar==4){
							Day=(int)(Math.random()*29);
						}else{
							Day=(int)(Math.random()*28);
						}
					}
					
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				Day=(int)Math.random()*30;
				break;
		}
			
		System.out.println("Test random datum");
		String startDateString = Integer.toString(Year)+"-"+Integer.toString(Month)+"-"+Integer.toString(Day);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
        Date startDate=null;
        String newDateString = null;
        try 
        {
            startDate = df.parse(startDateString);
            newDateString = df.format(startDate);
            System.out.println("startdate: "+startDate);
            System.out.println("newdatestring: "+newDateString);
            System.out.println("startdatestring: "+startDateString);
        } catch (ParseException e) 
        {
            e.printStackTrace();
        }
		return startDate;
    }
}
