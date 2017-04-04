package syllableCounter;

/**
 * Count syllable and vowels by countSyllables method that designed with O-O style.
 * @author Sathira Kittisukmongkol
 */
public class OOSyllableCounter extends WordCounterOO {

	/**
	 * Count the syllables of the input word.
	 * @param word , word that we will count.
	 * @return the number of syllable of that word.
	 */
	int countSyllables( String word ) {
		word = word.toLowerCase().trim();
		syllableCount = 0;
		finalChar = false;
		state2 = START;		
		for( int i=0 ; i<=word.length()-1 ; i++ ) {
			if( i == word.length()-1 ) {
				finalChar = true;
			}
			char c = word.charAt( i );
			state2.handleChar( c );
			state2.enterState();
			if( state2 == NONWORD ) {
				i = word.length()-1;
			}
		}
		return syllableCount;
	}
	
}