package syllableCounter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

	public static void main( String[]args ) {
		
		try{
			SimpleSyllableCounter x = new SimpleSyllableCounter();
		final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
		URL url = new URL( DICT_URL );
		InputStream input = url.openStream();
		int count = 0;
		BufferedReader reader = new BufferedReader( new InputStreamReader( input ) );
		while( true ) {
			String word = reader.readLine();
			if( word == null ) {
				break;
			}
			count = count + x.countSyllables(word);
		}
		System.out.println( count );
		}catch( Exception ex ) {
			System.out.println( ex.getMessage() );
		}
		
		
//		System.out.println(  x.countSyllables( "banana" ) );
//		System.out.println(  x.countSyllables( "durian" ) );
//		System.out.println(  x.countSyllables( "beauty" ) );
//		System.out.println(  x.countSyllables( "layout" ) );
//		System.out.println(  x.countSyllables( "apple" ) );
//		System.out.println(  x.countSyllables( "lourve" ) );
//		System.out.println(  x.countSyllables( "The" ) );
//		System.out.println(  x.countSyllables( "me" ) );
//		System.out.println(  x.countSyllables( "movie" ) );
//		System.out.println(  x.countSyllables( "levee" ) );
//		System.out.println(  x.countSyllables( "try" ) );
//		System.out.println(  x.countSyllables( "beyond" ) );
//		System.out.println(  x.countSyllables( "yesterday" ) );
//		System.out.println(  x.countSyllables( "yahoo" ) );
//		System.out.println(  x.countSyllables( "anti-oxidant" ) );
//		System.out.println(  x.countSyllables( "anti-" ) );
//		System.out.println(  x.countSyllables( "-oxidant" ) );
//		System.out.println(  x.countSyllables( "mrtg" ) );
//		System.out.println(  x.countSyllables( "I.B.M." ) );
//		System.out.println(  x.countSyllables( "7-Eleven" ) );
//		System.out.println(  x.countSyllables( "" ) );
//		System.out.println(  x.countSyllables( "" ) );
//		System.out.println(  x.countSyllables( word ) );
		
		
	}
	
}
