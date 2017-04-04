package syllableCounter;

/**
 * Use with non O-O approach.
 * Contain the checking method.
 * @author Sathira Kittisukmongkol
 */
public class WordCounterSS {

	private String word;
	private State state;
	char[] vowelOrY = { 'a' , 'e' , 'i' , 'o' , 'u' , 'y' };
	char[] vowel = { 'a' , 'e' , 'i' , 'o' , 'u' };
	char[] consonant = { 'b' , 'c' , 'd' , 'f' , 'g' , 'h' , 'j' , 'k' , 'l' , 'm' , 'n' , 'p' , 'q' , 'r' , 's' , 't' , 'v' , 'w' , 'x' , 'y' , 'z' };

	/**
	 * Check this method at the first time.
	 * Is the first character in vowel group or or be y.
	 * @param c , the first character of the word.
	 * @return true , if c is in vowel group or be y , otherwise , false. 
	 */
	public boolean isVowelOrY( char c ) {
		for( char x : vowelOrY ) {
			if( c == x ) {
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
	public boolean isLetter( char c ) {
		for( char x : consonant ) {
			if( x == c ) {
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
	public boolean isVowel( char c ) {
		for( char x : vowel ) {
			if( x == c ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the word that want to count from the Main class.
	 * @param word , input word.
	 */
	public void setWord( String word ) {
		this.word = word;
	}

}