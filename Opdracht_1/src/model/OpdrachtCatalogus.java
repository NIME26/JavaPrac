/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Emin
 * @version 10/10/2013
 *
 */
public class OpdrachtCatalogus implements Comparable<OpdrachtCatalogus>{
	
	private List<Opdracht> opdrachten;
	
	/**
	 * Default constructor
	 * 
	 * @throws IllegalArgumentException
	 */
	public OpdrachtCatalogus() throws IllegalArgumentException{
		this.setOpdrachten(new ArrayList<Opdracht>());
	}
	
	/**
	 * Constructor with 1 param
	 * 
	 * @param opdrachten
	 * @throws IllegalArgumentException
	 */
	public OpdrachtCatalogus(List<Opdracht> opdrachten) throws IllegalArgumentException{
		this.setOpdrachten(opdrachten);
	}

	// Selectors
	
	/**
	 * @return
	 */
	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}

	// Modifiers
	
	/**
	 * Set opdrachten
	 * 
	 * @param opdrachten
	 * @throws IllegalArgumentException
	 */
	public void setOpdrachten(List<Opdracht> opdrachten) throws IllegalArgumentException{
		if (opdrachten == null)throw new IllegalArgumentException("Opdrachten verzameling is null");
		this.opdrachten = opdrachten;
	}
	
	/**
	 * Add opdracht to list
	 * 
	 * @param opdracht
	 * @throws IllegalArgumentException
	 */
	public void addOpdracht(Opdracht opdracht) throws IllegalArgumentException{
		if (opdracht == null)throw new IllegalArgumentException("Opdracht is null!");
		for (Opdracht opdrachtCheck : opdrachten) {
			if (opdrachtCheck.equals(opdracht))throw new IllegalArgumentException("Opdracht bestaat al!");
		}
		opdrachten.add(opdracht);
	}
	
	/**
	 * Remove opdracht from list
	 * 
	 * @param opdracht
	 * @throws IllegalArgumentException
	 */
	public void removeOpdracht(Opdracht opdracht) throws IllegalArgumentException{
		if (opdracht == null)throw new IllegalArgumentException("Opdracht is null!");
		opdrachten.remove(opdracht);
	}
	
	/**
	 * Update opdracht from list
	 * 
	 * @param oldOpdracht
	 * @param newOpdracht
	 * @throws IllegalArgumentException
	 */
	public void updateOpdracht(Opdracht oldOpdracht, Opdracht newOpdracht) throws IllegalArgumentException{
		if (oldOpdracht == null)throw new IllegalArgumentException("oldOpdracht is null!");
		if (newOpdracht == null)throw new IllegalArgumentException("newOpdracht is null!");
		int index = opdrachten.lastIndexOf(oldOpdracht);
		opdrachten.set(index, newOpdracht);
	}
	
	// Comparisons
	
	/**
	 * Comparable
	 * 
	 * @param opdrachtCatalogus
	 * @return
	 */
	public int compareTo(OpdrachtCatalogus opdrachtCatalogus){
		return this.getOpdrachten().size() - opdrachtCatalogus.getOpdrachten().size();
	}
	
	// Overrides
	
	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opdrachten == null) ? 0 : opdrachten.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpdrachtCatalogus other = (OpdrachtCatalogus) obj;
		if (opdrachten == null) {
			if (other.opdrachten != null)
				return false;
		} else if (!opdrachten.equals(other.opdrachten))
			return false;
		return true;
	}
}
