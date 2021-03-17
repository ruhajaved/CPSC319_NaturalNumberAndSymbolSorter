import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class to aid in execution of program.
 */
public class Utility 
{
    /**
     * Enum to keep track of symbols accepted by program and their corresponding double-value key.
     */
    public enum Symbol
    {
        DO("Do", 0.5),
        RE("Re", 100.5),
        MI("Mi", 1000.5),
        AND("&", 3.5),
        AT("@", 3.3),
        PERCENT("%", 1005000.5),
        A_SYMBOL_WITH_A_REALLY_LONGNAME("Asymbolwithareallylongname", 55.5),
        DOLLAR("$", 20.5),
        FA("Fa", 15.5),
        ONE("One", 103.5),
        THREE("Three", 103.7),
        TWO("Two", 103.6);

        private final double key;       // double-valued key associated with enum constant
        private final String symbol;    // string symbol associated with enum constant - i.e. AT <--> "@"

        /**
         * Constructor.
         * @param symbol value to initalize symbol to.
         * @param key value to intialize key to.
         */
        private Symbol(String symbol, double key)
        {
            this.symbol = symbol;
            this.key = key;
        }

        /**
         * Getter for key.
         * @return returns key.
         */
        public double getKey()
        {
            return this.key;
        }

        /**
         * Returns symbol representation of the enum constant as a string - i.e. AND <--> "&"
         * @return returns symbol.
         */
        public String toString()
        {
            return this.symbol;
        }

        /**
         * Creates a regex string to be used by Pattern in Utlity.checkSymbol() function.
         * @return String representation of enum constants, seperated by |.
         */
        public static String getRegexString()
        {
            String s = Symbol.values()[0].toString();
            for(int i = 1; i < Symbol.values().length; i++)     // iterate through enum Symbol
            {
                String symbol = Symbol.values()[i].toString();  // get string rep. of enum constant
                if(symbol.equals("$"))                          // check if it's $ sign
                {
                    s = s + "|\\" + symbol;                     // if so, need to escape $ with regex
                }
                else
                {
                    s = s + "|" + symbol;
                }
            }
            return s;
        }
    }

    /**
     * checks if the current line read from the input file is valid input,
     * either a natural number (zero included) or valid symbol.
     * @param s the current line from the input file to check.
     * @return  returns input of valid, otherwise throws IllegalArgumentException.
     */
    public static double getElement(String s) throws IllegalArgumentException
    {        
        if(checkNaturalNumber(s)) // check if we have a natural number
        {
            double argument = Integer.parseInt(s, 10);      // convert to int, base 10
            return argument;
        }
        else if(checkSymbol(s))  // check if we have a valid symbol
        {
            for(Symbol symbol : Symbol.values())            // find symbol in enum
            {
                if((symbol.toString()).equals(s))
                {
                    double argument = symbol.getKey();      // get corresponding key to store
                    return argument;
                }
            }
        }
        throw new IllegalArgumentException();               // throw exception if invalid input
    }

    /**
     * Checks if string given is a valid natural number.
     * @param s string to check.
     * @return returns true if string is a valid natural number, otherwise false.
     */
    public static boolean checkNaturalNumber(String s)
    {
        // first see if we have a natural number
        String regex1 = "^[1-9]\\d*$";
        Pattern myPattern1 = Pattern.compile(regex1);
        Matcher myMatcher1 = myPattern1.matcher(s);
        if(myMatcher1.find())
        {
            return true;
        }

        // if not, then check if special case of 0, since we consider it to be a natural number
        String regex2 = "^0$";
        Pattern myPattern2 = Pattern.compile(regex2);
        Matcher myMatcher2 = myPattern2.matcher(s);
        if(myMatcher2.find())
        {
            return true;
        }
        return false;   // else return false
    }

    /**
     * Check if the given string is a valid symbol.
     * @param s string to check.
     * @return returns true of s is a valid symbol, false otherwise.
     */
    public static boolean checkSymbol(String s)
    {
        String regex1 = "^(" + Symbol.getRegexString() + ")$";
        Pattern myPattern1 = Pattern.compile(regex1);
        Matcher myMatcher1 = myPattern1.matcher(s);
        if(myMatcher1.find())
        {
            return true;
        }
        return false;
    }

    /**
     * Checks if value given matches an enum constant in Symbol.
     * @param key key to check.
     * @return returns true if match found, else false.
     */
    public static boolean checkKey(double key)
    {
        for(Symbol symbol: Symbol.values())
        {
            if(symbol.getKey() == key)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Get's symbol from enum Symbol in String form, 
     * correspondign to the key given; this function assumes key is VALID.
     * @param key key to get symbol for.
     * @return  returns symbol in the form of a String.
     */
    public static String keyToSymbol(double key)
    {
        for(Symbol symbol: Symbol.values())
        {
            if(symbol.getKey() == key)
            {
                return symbol.toString();
            }
        }
        return "Reached an unreachable state";  // if key is not found in enum - which is unexpected.
    }

    /**
     * Converts ArrayList object to a string[] representation.
     * @param myList ArrayList object to convert.
     * @return returns string[] which represents content stored by myList.
     */
    public static String[] arrayToString(ArrayList myList)
    {
        String[] result = new String[myList.getSize()];
        for(int i = 0; i < result.length; i++)
        {
            String s;
            double value = myList.getIndex(i);
            if(checkKey(value))                         // if value represents a symbol
            {
                s = keyToSymbol(value);                 // get symbol
            }
            else                                        // if value is simply a natural number read in
            {
                s = Integer.toString((int) value);      // convert value into natural number representation
            }
            result[i] = s;
        }
        return result;
    }
}
