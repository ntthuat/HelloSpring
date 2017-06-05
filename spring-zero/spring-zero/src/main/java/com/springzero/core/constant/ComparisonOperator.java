package com.springzero.core.constant;

/**
 * ComparisonOperator
 * 
 * @author Thuat T Nguyen
 * @version 06/02/2017
 */
public enum ComparisonOperator {
	/**
	 * String value has to be used to avoid compilation error. However, its
	 * value must be revised according to NOT_EQUAL
	 */
	EQUAL("=", "NOT_EQUAL"), NOT_EQUAL("<>", EQUAL),
	/**
	 * String value has to be used to avoid compilation error. However, its
	 * value must be revised according to NO_LESS
	 */
	LESS("<", "NO_LESS"), NO_LESS(">=", LESS),
	/**
	 * String value has to be used to avoid compilation error. However, its
	 * value must be revised according to NO_GREATER
	 */
	GREATER(">", "NO_GREATER"), NO_GREATER("<=", GREATER);

	/** rendered */
	private final String rendered;
	/** negated */
	private ComparisonOperator negated;
	/** strNegated */
	private final String strNegated;

	/**
	 * This Constructor is causing cyclic dependency which is resulting in
	 * java.lang.ExceptionInInitializerError
	 * 
	 * @param rendered rendered
	 * @param negated negated
	 */
	private ComparisonOperator(final String rendered, final ComparisonOperator negated) {
		this.rendered = rendered;
		this.negated = negated;
		this.strNegated = null;
	}

	/**
	 * Constructor
	 * 
	 * @param rendered rendered
	 * @param strNegated strNegated
	 */
	private ComparisonOperator(final String rendered, final String strNegated) {
		this.rendered = rendered;
		this.negated = null;
		this.strNegated = strNegated;
	}

	/**
	 * getter
	 * 
	 * @return rendered
	 */
	public String rendered() {
		return rendered;
	}

	/**
	 * Return the negated
	 * 
	 * @return the negated
	 */
	public ComparisonOperator getNegated() {
		if (negated == null) {
			negated = valueOf(strNegated);
		}
		return negated;
	}
}
