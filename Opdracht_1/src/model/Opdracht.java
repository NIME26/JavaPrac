/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.DatumGC;

/**
 * 
 * @author Emin
 * @version 9/10/2013
 *
 */
public class Opdracht implements Comparable<Opdracht>{
	
	public enum OpdrachtCategorie {
		REKENEN,
		NEDERLANDSENAAM,
		FRANSETAAL,
		ALGEMENEKENNIS
	}
	
	private String question;
	private String correctAnswer;
	private String[] answerHints;
	private int maxNumberOfAttempts;
	private int maxAnswerTime;
	private OpdrachtCategorie categorie;
	private Leraar auteur;
	private List<Quiz> quizzen;
	private DatumGC datumRegistratie;
	
	// Constructors
	
	/**
	 * Default constructor
	 */
	public Opdracht() throws IllegalArgumentException{
		this.setQuestion("leeg");
		this.setCorrectAnswer("leeg");
		this.setAnswerHints(new String[]{"leeg"});
		this.setMaxNumberOfAttempts(1);
		this.setMaxAnswerTime(1);
		this.setCategorie(Opdracht.OpdrachtCategorie.ALGEMENEKENNIS);
		this.setAuteur(Leraar.BAKKER);
		this.setQuizzen(new ArrayList<Quiz>());
		this.setDatumRegistratie(new DatumGC());
	}
	
	/**
	 * Constructor with 6 params
	 * 
	 * @param question
	 * @param correctAnswer
	 * @param answerHints
	 * @param maxNumberOfAttempts
	 * @param maxAnswerTime
	 */
	public Opdracht(String question,String correctAnswer,String[] answerHints,
			int maxNumberOfAttempts,int maxAnswerTime,OpdrachtCategorie categorie,
			Leraar auteur,List<Quiz> quizzen,DatumGC datumRegistratie) throws IllegalArgumentException{
		this.setQuestion(question);
		this.setCorrectAnswer(correctAnswer);
		this.setAnswerHints(answerHints);
		this.setMaxNumberOfAttempts(maxNumberOfAttempts);
		this.setMaxAnswerTime(maxAnswerTime);
		this.setCategorie(categorie);
		this.setAuteur(auteur);
		this.setQuizzen(quizzen);
		this.setDatumRegistratie(datumRegistratie);
	}

	// Selectors
	
	/**
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * @return correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @return answerHints
	 */
	public String[] getAnswerHints() {
		return answerHints;
	}

	/**
	 * @return maxNumberOfAttempts
	 */
	public int getMaxNumberOfAttempts() {
		return maxNumberOfAttempts;
	}

	/**
	 * @return maxAnswerTime
	 */
	public int getMaxAnswerTime() {
		return maxAnswerTime;
	}

	/**
	 * @return
	 */
	public OpdrachtCategorie getCategorie() {
		return categorie;
	}

	/**
	 * @return
	 */
	public Leraar getAuteur() {
		return auteur;
	}

	/**
	 * @return
	 */
	public List<Quiz> getQuizzen() {
		return quizzen;
	}

	/**
	 * @return
	 */
	public DatumGC getDatumRegistratie() {
		return datumRegistratie;
	}

	// Modifiers
	
	/**
	 * Set question
	 * 
	 * @param question
	 */
	public void setQuestion(String question) throws IllegalArgumentException{
		if (question == null)throw new IllegalArgumentException("Vraag is null!");
		if (question.isEmpty())throw new IllegalArgumentException("Gelieve een vraag in te vullen!");
		this.question = question;
	}
	
	/**
	 * Set correctAnswer
	 * 
	 * @param correctAnswer
	 */
	public void setCorrectAnswer(String correctAnswer) throws IllegalArgumentException{
		if (correctAnswer == null)throw new IllegalArgumentException("Juiste antwoord is null!");
		if (correctAnswer.isEmpty())throw new IllegalArgumentException("Gelieve een juiste antwoord in te vullen!");
		this.correctAnswer = correctAnswer;
	}

	/**
	 * Set answerHits
	 * 
	 * @param answerHints
	 */
	public void setAnswerHints(String[] answerHints) throws IllegalArgumentException{
		if (answerHints == null)throw new IllegalArgumentException("Antwoord hints verzameling is null");
		if (answerHints.length == 0)throw new IllegalArgumentException("Antwoord hints verzameling is leeg");
		this.answerHints = answerHints;
	}

	/**
	 * Set maxNumberOfAttempts
	 * 
	 * @param maxNumberOfAttempts
	 */
	public void setMaxNumberOfAttempts(int maxNumberOfAttempts) throws IllegalArgumentException{
		if (maxNumberOfAttempts <= 0)throw new IllegalArgumentException("Aantal pogingen kunnen niet 0 of negatief zijn!");
		this.maxNumberOfAttempts = maxNumberOfAttempts;
	}

	/**
	 * Set maxAnswerTime
	 * 
	 * @param maxAnswerTime
	 */
	public void setMaxAnswerTime(int maxAnswerTime) throws IllegalArgumentException{
		if (maxAnswerTime <= 0)throw new IllegalArgumentException("Max antwoord tijd kan niet 0 of negatief zijn!");
		this.maxAnswerTime = maxAnswerTime;
	}

	/**
	 * Set categorie
	 * 
	 * @param categorie
	 */
	public void setCategorie(OpdrachtCategorie categorie) throws IllegalArgumentException{
		if (categorie == null)throw new IllegalArgumentException("Categorie is null!");
		this.categorie = categorie;
	}

	/**
	 * Set auteur
	 * 
	 * @param auteur
	 */
	public void setAuteur(Leraar auteur) throws IllegalArgumentException{
		if (auteur == null)throw new IllegalArgumentException("Auteur is null!");
		this.auteur = auteur;
	}

	/**
	 * Set quizzen
	 * 
	 * @param quizzen
	 */
	public void setQuizzen(List<Quiz> quizzen) {
		if (quizzen == null)throw new IllegalArgumentException("Quizzen verzameling is null!");
		this.quizzen = quizzen;
	}

	/**
	 * Set datumRegistratie
	 * 
	 * @param datumRegistratie
	 */
	public void setDatumRegistratie(DatumGC datumRegistratie) {
		if (datumRegistratie == null)throw new IllegalArgumentException("Datum is null");
		this.datumRegistratie = datumRegistratie;
	}
	
	// Comparisons
	
	/**
	 * Compares input answer with correct answer
	 * 
	 * @param answer
	 * @return
	 */
	public boolean isCorrectAnswer(String answer){
		if (this.correctAnswer == answer)
			return true;
		return false;
	}
	
	/**
	 * Comparable
	 * 
	 * @param opdracht
	 * @return
	 */
	public int compareTo(Opdracht opdracht){
		return this.getQuestion().compareTo(opdracht.getQuestion());
	}
	
	//Overrides
	
	@Override
	public String toString() {
		return "Opdracht [question=" + question + ", correctAnswer="
				+ correctAnswer + ", answerHints="
				+ Arrays.toString(answerHints) + ", maxNumberOfAttempts="
				+ maxNumberOfAttempts + ", maxAnswerTime=" + maxAnswerTime
				+ ", categorie=" + categorie + ", auteur=" + auteur
				+ ", quizzen=" + quizzen + ", datumRegistratie="
				+ datumRegistratie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(answerHints);
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result
				+ ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime
				* result
				+ ((datumRegistratie == null) ? 0 : datumRegistratie.hashCode());
		result = prime * result + maxAnswerTime;
		result = prime * result + maxNumberOfAttempts;
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((quizzen == null) ? 0 : quizzen.hashCode());
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
		Opdracht other = (Opdracht) obj;
		if (!Arrays.equals(answerHints, other.answerHints))
			return false;
		if (auteur != other.auteur)
			return false;
		if (categorie != other.categorie)
			return false;
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
			return false;
		if (datumRegistratie == null) {
			if (other.datumRegistratie != null)
				return false;
		} else if (!datumRegistratie.equals(other.datumRegistratie))
			return false;
		if (maxAnswerTime != other.maxAnswerTime)
			return false;
		if (maxNumberOfAttempts != other.maxNumberOfAttempts)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (quizzen == null) {
			if (other.quizzen != null)
				return false;
		} else if (!quizzen.equals(other.quizzen))
			return false;
		return true;
	}
}
