package syllableCounter;

public class OOSyllableCounter {

	abstract class State {
		
		public abstract void handleChar( char c );
		
		public void enterState() {
			/* default is to do nothing */
		}
		
	}
	
	class SingleVowelState extends State {
		
		public void handleChar( char c ) {
			if( isVowel( c ) ) {
				setState( MULTIVOWEL );
			}
		}
		
		public void enterState( ) {
			syllableCount++;
		}
		
	}
	
	int countSyllables( String word ) {
		int syllables = 0;
		char c = ' ';
		State state = State.START; // State is an enum of the states 
		for(int k=0; k<word.length(); k++) {
			c = word.charAt(k);
			if ( c == '\'' ) { 
				// ignore apostrophe switch(state)
				continue;
			}
			switch( state ) {
			// process character c using state machine 
			case CONSONANT:
				if ( isVowelOrY(c) ) { 
					state = State.SINGLEVOWEL; 
					syllables++; 
				}
				else if ( isLetter(c) ) {
					/* stay in consonant state */
				}
				else if ( c == '-' ) {
					state = State.HYPHEN ;
				}
				else {
					state = State.NONWORD;
				}
				break;
			case VOWEL:
				if ( isVowel( c ) ) {
					state = State.MULTIVOWEL;
				}
				else {
					//TODO
				}
				break;
			default:
				break;
				//TODO other cases
			}
		}
	}
	
}
