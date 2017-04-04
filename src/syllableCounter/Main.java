package syllableCounter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * @author Sathira Kittisukmongkol
 */
public class Main {

	/**
	 * Count by SimpleSyllableCounter solution.
	 */
	public static void main(String[] args) {
		try{
			SimpleSyllableCounter x = new SimpleSyllableCounter();
			final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
			URL url = new URL( DICT_URL );
			double startTime = System.nanoTime();
			InputStream input = url.openStream();
			int countVowel = 0;
			int countWord = 0;
			int tempBox ;
			BufferedReader reader = new BufferedReader( new InputStreamReader( input ) );
			while( true ) {
				String word = reader.readLine();
				if( word == null ) {
					break;
				}
				tempBox = x.countSyllables(word);
				if( tempBox > 0 ) {
					countWord = countWord + 1;
				}
				countVowel = countVowel + x.countSyllables(word);

			}
			double stopTime = System.nanoTime();
			System.out.println( "Reading words from "+DICT_URL+"\n" );
			System.out.println( "Counted "+countVowel+" syllables in "+countWord+"\n" );
			System.out.printf( "Elapsed time: %.3f sec\n" , ((stopTime-startTime)*(1.0E-9)) );
		}catch( Exception ex ) {
			System.out.println( ex.getMessage() );
		}
	}
	
	/**
	 * Count by OOSyllableCounter solution.
	 */
//	public static void main(String[] args) {
//		try{
//			OOSyllableCounter x = new OOSyllableCounter();
//			final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
//			URL url = new URL( DICT_URL );
//			double startTime = System.nanoTime();
//			InputStream input = url.openStream();
//			int countVowel = 0;
//			int countWord = 0;
//			int tempBox ;
//			BufferedReader reader = new BufferedReader( new InputStreamReader( input ) );
//			while( true ) {
//				String word = reader.readLine();
//				if( word == null ) {
//					break;
//				}
//				tempBox = x.countSyllables(word);
//				if( tempBox > 0 ) {
//					countWord = countWord + 1;
//				}
//				countVowel = countVowel + x.countSyllables(word);
//
//			}
//			double stopTime = System.nanoTime();
//			System.out.println( "Reading words from "+DICT_URL+"\n" );
//			System.out.println( "Counted "+countVowel+" syllables in "+countWord+"\n" );
//			System.out.printf( "Elapsed time: %.3f sec\n" , ((stopTime-startTime)*(1.0E-9)) );
//		}catch( Exception ex ) {
//			System.out.println( ex.getMessage() );
//		}
//	}

}
