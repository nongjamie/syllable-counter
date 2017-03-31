package syllableCounter;

public WordCounter {
	//---------------------------------------------------------------------------------
	abstract class State {

		public abstract void handleChar( char c );

		public void enterState() {
			/* default is to do nothing */
		}

	}
	//---------------------------------------------------------------------------------
	char[] vowelOrY = { 'a' , 'e' , 'i' , 'o' , 'u' , 'y' };
	char[] vowel = { 'a' , 'e' , 'i' , 'o' , 'u' };
	private final State START = new StartState();
	private final State CONSONANT = new ConsonantState();
	private final State VOWEL = new VowelState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State MULTIVOWEL = new MultiVowelState();
	private final State HYPHEN = new HyphenState();
	private final State NONWORD = new NonwordState();
	private State state;
	private int syllableCount = 0;
	//---------------------------------------------------------------------------------
	class StartState extends State {

		@Override
		public void handleChar(char c) {

		}

	}

	class ConsonantState extends State {

		@Override
		public void handleChar(char c) {
			if( isVowel( c ) ) {
				setState( VOWEL );
			}
			else if( isLetter( c ) ) {
				setState( CONSONANT );
			}
			else {
				setState( NONWORD );
			}
		}

	}

	class VowelState extends State {

		@Override
		public void handleChar(char c) {

		}

	}

	class SingleVowelState extends State {

		public void handleChar( char c ) {
			if( isVowel( c ) ) {
				setState( MULTIVOWEL );
			}
			else if( isVowel( c ) ) {
				setState( CONSONANT );
			}
			else {
				setState( NONWORD );
			}
		}

		public void enterState( ) {
			syllableCount++;
		}

	}

	class MultiVowelState extends State {

		@Override
		public void handleChar(char c) {
			if( isVowel( c ) ) {
				// Do nothing
			}
			else if( isLetter( c ) ) {
				setState( CONSONANT );
			}
			else {
				setState( NONWORD );
			}
		}

	}

	class HyphenState extends State {

		@Override
		public void handleChar(char c) {
			if( isVowel( c ) ) {
				setState( VOWEL );
			}
			else if( isLetter( c ) ) {
				setState( CONSONANT );
			}
			else {
				setState( NONWORD );
			}
		}

	}

	class NonwordState extends State {

		@Override
		public void handleChar(char c) {

		}

	}
	//---------------------------------------------------------------------------------
	public void setState( State newstate ) {
		state = newstate;
	}

	public boolean isVowelOrY( char c ) {
		for( char x : vowelOrY ) {
			if( c == x ) {
				return true;
			}
		}
		return false;
	}

	public boolean isLetter( char c ) {
		for( char x : vowel ) {
			if( x == c ) {
				return false;
			}
		}
		return true;
	}

	public boolean isVowel( char c ) {
		for( char x : vowel ) {
			if( x == c ) {
				return true;
			}
		}
		return false;
	}
	//---------------------------------------------------------------------------------

}