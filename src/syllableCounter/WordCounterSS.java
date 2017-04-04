package syllableCounter;

/**
 * 
 * @author Sathira Kittisukmongkol
 */
public class WordCounterSS {

	private String word;
	private State state;
	char[] vowelOrY = { 'a' , 'e' , 'i' , 'o' , 'u' , 'y' };
	char[] vowel = { 'a' , 'e' , 'i' , 'o' , 'u' };
	char[] consonant = { 'b' , 'c' , 'd' , 'f' , 'g' , 'h' , 'j' , 'k' , 'l' , 'm' , 'n' , 'p' , 'q' , 'r' , 's' , 't' , 'v' , 'w' , 'x' , 'y' , 'z' };

	public boolean isVowelOrY( char c ) {
		for( char x : vowelOrY ) {
			if( c == x ) {
				return true;
			}
		}
		return false;
	}

	public boolean isLetter( char c ) {
		for( char x : consonant ) {
			if( x == c ) {
				return true;
			}
		}
		return false;
	}

	public boolean isVowel( char c ) {
		for( char x : vowel ) {
			if( x == c ) {
				return true;
			}
		}
		return false;
	}

	public void setWord( String word ) {
		this.word = word;
	}

}