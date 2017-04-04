package syllableCounter;

/**
 * 
 * @author Sathira Kittisukmongkol
 */
public class SimpleSyllableCounter extends WordCounterSS {
	
	int countSyllables( String word ) {
		word = word.toLowerCase().trim();
		int syllables = 0;
		boolean lastCharIsE = false;
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
					else if( c=='e' && k!=word.length()-1 && syllables!=0){
						lastCharIsE = true;
						state = State.SINGLEVOWEL;
						syllables++;
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
				else if( c=='-' && (k!=word.length()-1) && lastCharIsE==true ) {
					syllables = syllables - 1 ;
					state = State.HYPHEN;
					lastCharIsE = false;
				}
				else if( c=='-' && (k!=word.length()-1) && lastCharIsE==false) {
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

}