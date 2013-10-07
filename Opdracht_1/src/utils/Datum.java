package utils;
import java.util.*;

public class Datum implements Comparable<Datum> {
	private int jaar;
	private int maand;
	private int dag;
	private Map<Integer, String> months;
	
	/**
	 * @param jaar
	 * @param maand
	 * @param dag
	 */
	public Datum(int jaar, int maand, int dag) throws IllegalArgumentException {
		LoadMonths();
		setDatum(jaar,maand,dag);
	}

	public Datum(Datum d){
		setDatum(d);
	}

	public Datum(){}

	private void setDatum(int jaar, int maand, int dag) {
		if(dag == 29 && maand == 2 && !IsLeapYear(jaar))
			throw new IllegalArgumentException("De ingevoerde datum is geen correcte datum - Jaar is geen schrikkeljaar");
		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar;
	}
	
	private void setDatum(Datum d) {
		if(d.dag == 29 && d.maand == 2 && !IsLeapYear(d.jaar))
			throw new IllegalArgumentException("De ingevoerde datum is geen correcte datum - Jaar is geen schrikkeljaar");
		this.dag = d.dag;
		this.maand = d.maand;
		this.jaar = jaar;
	}
	
	private void LoadMonths() {
		months.put(1, "Januari");
		months.put(2, "Februari");
		months.put(3, "Maart");
		months.put(4, "April");
		months.put(5, "Mei");
		months.put(6, "Juni");
		months.put(7, "Juli");
		months.put(8, "Augustus");
		months.put(9, "September");
		months.put(10, "Oktober");
		months.put(11, "November");
		months.put(12, "December");
	}

	/**
	 * @return the jaar
	 */
	public int getJaar() {
		return jaar;
	}
	/**
	 * @param jaar the jaar to set
	 */
	public void setJaar(int jaar) throws IllegalArgumentException {
		if(jaar < 0)
			this.jaar = jaar;
		else throw new IllegalArgumentException("Jaar mag niet kleiner zijn als 0");
	}
	/**
	 * @return the maand
	 */
	public int getMaand() {
		return maand;
	}
	/**
	 * @param maand the maand to set
	 */
	public void setMaand(int maand)throws IllegalArgumentException {
		if(maand >= 1 && maand <= 12)
			this.maand = maand;
		else throw new IllegalArgumentException("Maand moet tussen 1 en 12 liggen!");	
	}
	/**
	 * @return the dag
	 */
	public int getDag() {
		return dag;
	}
	/**
	 * @param dag the dag to set
	 */
	public void setDag(int dag)throws IllegalArgumentException  {
		if(dag >= 1 && dag <= 31)
			this.dag = dag;
		else throw new IllegalArgumentException("Dag moet tussen 1 & 31 liggen");	
	}
	
	/**
	 * *
	 * @param jaar
	 * @return boolean if the given year is a leapyear
	 */
	public boolean IsLeapYear(int jaar)
	{
		if((jaar % 4 == 0) && jaar % 100 != 0)
			return true;
		else if((jaar % 400 == 0))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString()
	{
		return String.format("%d %s %d", this.dag,months.get(this.maand),this.jaar);
	}
	
	public String getDatumInAmerikaansFormaat()
	{
		return String.format("%d;%d:%d", this.jaar,this.maand,this.dag);
	}
	
	public String getDatumInEuropeesFormaat()
	{
		return String.format("%d;%d:%d", this.dag,this.maand,this.jaar);
	}
	
	@Override
	public boolean equals(Datum obj) {
		if(this.jaar != obj.jaar)
			return false;
		if(this.maand != obj.maand)
			return false;
		if(this.dag != obj.dag)
			return false;
	}
	}

}