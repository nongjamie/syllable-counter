package syllableCounter;

public class SimpleSyllableCounter {
	//---------------------------------------------------------------------------------
	private State state;
	char[] vowelOrY = { 'a' , 'e' , 'i' , 'o' , 'u' , 'y' };
	char[] vowel = { 'a' , 'e' , 'i' , 'o' , 'u' };
	char[] consonant = { 'b' , 'c' , 'd' , 'f' , 'g' , 'h' , 'j' , 'k' , 'l' , 'm' , 'n' , 'p' , 'q' , 'r' , 's' , 't' , 'v' , 'w' , 'x' , 'y' , 'z' };
	//---------------------------------------------------------------------------------
	int countSyllables( String word ) {
		word = word.toLowerCase().trim();
		int syllables = 0;
		State state = State.START; // State is an enum of the states 
		for( int k=0 ; k<word.length() ; k++ ) {
			char c = word.charAt( k );
			switch ( state ) {
			case START:
				if ( isVowelOrY(c) ) {
					state = State.SINGLEVOWEL;
					syllables++;
				}
				else if( isLetter(c) ) {
					state = State.CONSONANT;
				}
				else if( c=='-' ) {
					state = State.NONWORD;
					k = word.length();
				}
				else {
					state = State.NONWORD;
					k = word.length();
					syllables=0;
				}
				break;
			case CONSONANT:
				if( isVowel(c) ) {
					if( c=='e' && k==word.length()-1 && syllables!=0){
						state = State.CONSONANT;
					}
					else{
						state = State.SINGLEVOWEL;
						syllables++;
					}
				}
				else if( c=='y' ) {
					state = State.SINGLEVOWEL;
					syllables++;
				}
				else if( isLetter(c) ) {
					state = State.CONSONANT;
				}
				else if( c=='-' ) {
					state = State.CONSONANT;
				}
				else if( c=='\'' ) {
					state = State.CONSONANT;
				}
				else {
					state = State.NONWORD;
					k = word.length();
					syllables=0;
				}
				break;
			case SINGLEVOWEL:
				if( isVowel(c) ) {
					if( c=='e' && k==word.length()-1 ){
						state = State.CONSONANT;
					}
					else{
						state = State.MULTIVOWEL;
					}
				}
				else if( isLetter(c) ) {
					state = State.CONSONANT;
				}
				else if( c=='-' && (k!=word.length()-1)) {
					state = State.HYPHEN;
				}
				else if( c=='-' && (k==word.length()-1)) {
					state = State.HYPHEN;
				}
				else if( c=='\'' ) {
					state = State.SINGLEVOWEL;
				}
				else {
					state = State.NONWORD;
					k = word.length();
					syllables=0;
				}
				break;
			case MULTIVOWEL:
				if( isVowel(c) ) {
					state = State.MULTIVOWEL;
				}
				else if( isLetter(c) ) {
					state = State.CONSONANT;
				}
				else if( c=='-' && (k!=word.length()-1)) {
					state = State.MULTIVOWEL;
				}
				else if( c=='-' && (k==word.length()-1)) {
					state = State.NONWORD;
				}
				else if( c=='\'' ) {
					state = State.MULTIVOWEL;
				}
				else {
					state = State.NONWORD;
					k = word.length();
					syllables=0;
				}
				break;
			case HYPHEN:
				if( isLetter(c) ) {
					state = State.CONSONANT;
				}
				else if( isVowelOrY(c) ) {
					state = State.SINGLEVOWEL;
					syllables++;
				}
				else if( c=='-' && (k!=word.length()-1)) {
					state = State.HYPHEN;
				}
				else if( c=='-' && (k==word.length()-1)) {
					state = State.NONWORD;
				}
				else if( c=='\'' ) {
					state = State.HYPHEN;
				}
				else {
					state = State.NONWORD;
					k = word.length();
					syllables=0;
				}
				break;
			case NONWORD:
				k = word.length()-1;
				syllables = 0;
				break;
			}
		}
		return syllables;
	}
	//			currentLetter = word.charAt(k);
	//			if( currentLetter == '\'' ) { 
	//				// ignore apostrophe switch(state)
	//				continue;
	//			}
	//			else if( isVowelOrY( currentLetter ) ) {
	//				state = State.VOWEL;
	//			}
	//			else if( isLetter( currentLetter ) ) {
	//				state = State.CONSONANT;
	//			}
	//			else {
	//				state = State.NONWORD;
	//			}
	//			switch( state ) {
	//			// process character c using state machine 
	//			case CONSONANT:
	//				if ( isVowelOrY(c) ) { 
	//					state = State.SINGLEVOWEL; 
	//					syllables++; 
	//				}
	//				else if ( isLetter(c) ) {
	//					/* stay in consonant state */
	//				}
	//				else if ( c == '-' ) {
	//					state = State.HYPHEN ;
	//				}
	//				else {
	//					state = State.NONWORD;
	//				}
	//				break;
	//			case VOWEL:
	//				if ( isVowel( c ) ) {
	//					state = State.MULTIVOWEL;
	//				}
	//				else {
	//					//TODO
	//				}
	//				break;
	//			case NONWORD:
	//				break;
	//			default:
	//				break;
	//				//TODO other cases
	//			}
	//		}
	//	}
	// end of loop for chars in word
	// End of word: Correct syllable count for the "final e" rule.
	// You only need the current state and current letter to do this
	//---------------------------------------------------------------------------------
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
	//---------------------------------------------------------------------------------
}
