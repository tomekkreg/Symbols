package pl.eit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Symbols {

	Map< String , String > allSymbols = new HashMap< >( );
	List< String > noSymbols = new ArrayList< >( );
	Symbols( ) {
		String[ ] elements = Elements.allElements.split( " " );
		System.out.println( "Total number of elements: " + elements.length );
		for ( String element : elements ) {
			if ( noSymbol( element ) ) noSymbols.add( element );
		}
		System.out.println( "Symbols assigned to " + allSymbols.size( ) + " elements\n" + 
					"No symbol for " + noSymbols.size( ) + " elements: " + noSymbols );
	}
	//Tries to assign a symbol to the element
	Boolean noSymbol( String element ) {
		int length = element.length( );
		for ( int first = 0 ;  first < length - 1 ; first++ ) {
			String symbolFirst = element.substring( first , first + 1 ).toUpperCase( );
			for ( int second = first + 1 ; second < length ; second++ ) {
				String symbol = symbolFirst + element.charAt( second );
				if ( allSymbols.containsKey( symbol ) ) continue;
				allSymbols.put( symbol , element );					// success
				return false;
			}
		}
		return true;
	}
	public static void main( String[ ] args ) { new Symbols( ); }
}
