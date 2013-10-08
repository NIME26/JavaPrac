/**
 * 
 */
package model;

import java.util.Arrays;

/**
 * 
 * @author Emin
 * @version 8/10/2013
 *
 */
public class Opdracht implements Comparable<Opdracht>{
	
	private String question;
	private String correctAnswer;
	private String[] answerHints;
	private int maxNumberOfAttempts;
	private int maxAnswerTime;
	
	// Constructors
	
	/**
	 * Default constructor
	 */
	public Opdracht() throws IllegalArgumentException{
		this.question = "";
		this.correctAnswer = "";
		this.answerHints = new String[0];
		this.maxNumberOfAttempts = 0;
		this.maxAnswerTime = 0;
	}
	
	/**
	 * Constructor with 5 params
	 * 
	 * @param question
	 * @param correctAnswer
	 * @param answerHints
	 * @param maxNumberOfAttempts
	 * @param maxAnswerTime
	 */
	public Opdracht(String question,String correctAnswer,String[] answerHints,
			int maxNumberOfAttempts,int maxAnswerTime) throws IllegalArgumentException{
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.answerHints = answerHints;
		this.maxNumberOfAttempts = maxNumberOfAttempts;
		this.maxAnswerTime = maxAnswerTime;
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

	// Modifiers
	
	/**
	 * Set question
	 * 
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * Set correctAnswer
	 * 
	 * @param correctAnswer
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	 * Set answerHits
	 * 
	 * @param answerHints
	 */
	public void setAnswerHints(String[] answerHints) {
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
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(answerHints);
		result = prime * result
				+ ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result + maxAnswerTime;
		result = prime * result + maxNumberOfAttempts;
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
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
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
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
		return true;
	}
}
