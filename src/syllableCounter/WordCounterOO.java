package syllableCounter;

import syllableCounter.WordCounterOO.ConsonantState;
import syllableCounter.WordCounterOO.MultiVowelState;
import syllableCounter.WordCounterOO.NonwordState;
import syllableCounter.WordCounterOO.SingleVowelState;
import syllableCounter.WordCounterOO.StartState;
import syllableCounter.WordCounterOO.State2;

/**
 * Use with O-O approach.
 * Contain the state while checking each character.
 * @author Sathira Kittisukmongkol
 */
public class WordCounterOO {
	
	public final State2 START = new StartState();
	public final State2 SINGLEVOWEL = new SingleVowelState();
	public final State2 MULTIVOWEL = new MultiVowelState();
	public final State2 CONSONANT = new ConsonantState();
	public final State2 NONWORD = new NonwordState();
	public State2 state2; // The current state
	public boolean lastCharIsE = true;
	public boolean finalChar; 
	public int syllableCount;
	char[] vowelOrY = { 'a', 'e', 'i', 'o', 'u', 'y' };
	char[] vowel = { 'a', 'e', 'i', 'o', 'u' };
	char[] consonant = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
			'y', 'z' };

	/**
	 * Declare the properties of each state.
	 */
	interface State2 {

		public void handleChar(char c);

		public void enterState();
		/* default is to do nothing */

	}

	/**
	 * Start state when the counter is begin.
	 */
	class StartState implements State2 {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				setState(SINGLEVOWEL);
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else if (c != '\'') {
				setState(NONWORD);
			} else {
				/* Do nothing. */
			}
		}

		@Override
		public void enterState() {
			/* Do nothing. */ }

	}

	/**
	 * When first found vowel.
	 * Enter this state must increase syllableCount variable by 1.
	 */
	class SingleVowelState implements State2 {

		@Override
		public void handleChar(char c) {
			if (isVowel(c)) {
				setState(MULTIVOWEL);
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '\'') {

			} else if (c == '-') {
				if (finalChar) {
					setState(START);
				} else if (lastCharIsE) {
					syllableCount = syllableCount - 1;
					setState(START);
				} else {
					setState(START);
				}
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount = syllableCount + 1;
		}

	}

	/**
	 * When found two or more vowels group together.
	 * Enter this state mustn't increase syllableCount variable by 1 like SingleVowel state.
	 */
	class MultiVowelState implements State2 {

		@Override
		public void handleChar(char c) {
			if (isVowel(c)) {
				setState(MULTIVOWEL);
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '\'') {
				/* Do nothing. */
			} else if (c == '-') {
				if (finalChar) {
					setState(NONWORD);
				} else {
					setState(START);
				}
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			/* Do nothing. */ }

	}

	/**
	 * When found character that isn't in vowel group.
	 * Enter this state do nothing.
	 */
	class ConsonantState implements State2 {

		@Override
		public void handleChar(char c) {
			if (isVowel(c) || c == 'y') {
				if (finalChar && c == 'e' && syllableCount != 0) {
					setState(CONSONANT);
				} else {
					if (c == 'e') {
						lastCharIsE = true;
						setState(SINGLEVOWEL);
					} else {
						lastCharIsE = false;
						setState(SINGLEVOWEL);
					}
				}
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '\'') {
				/* Do nothing. */
			} else if (c == '-') {
				if (finalChar) {
					setState(NONWORD);
				} else {
					setState(START);
				}
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			/* Do nothing. */ }

	}

	/**
	 * When found character that isn't in vowel and consonant group .
	 * Enter this state , therfore that input is not a word .
	 * So set syllableCount to be 0.
	 */
	class NonwordState implements State2 {
		
		@Override
		public void handleChar(char c) {
			/* Do nothing. */ }

		@Override
		public void enterState() {
			syllableCount = 0;
		}
		
	}

	/**
	 * Check this method at the first time.
	 * Is the first character in vowel group or or be y.
	 * @param c , the first character of the word.
	 * @return true , if c is in vowel group or be y , otherwise , false. 
	 */
	public boolean isVowelOrY(char c) {
		for (char x : vowelOrY) {
			if (x == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check the consonant.
	 * Is c in consonant group.
	 * @param c , the current character of the word.
	 * @return true , if c is in consonant group , otherwise , false. 
	 */
	public boolean isLetter(char c) {
		for (char x : consonant) {
			if (x == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check the vowel.
	 * Is the current character in vowel group .
	 * @param c , the current character of the word.
	 * @return true , if c is in vowel group , otherwise , false. 
	 */
	public boolean isVowel(char c) {
		for (char x : vowel) {
			if (x == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Change the state. 
	 * @param newstate , the goal state the we want to change into.
	 */
	public void setState(State2 newState) {
		this.state2 = newState;
	}

}
