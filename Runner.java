/**
 * Class used to run program.
 */
public class Runner
{
    public static void main(String[] args)
    {
        IO pipe = new IO();                                     // create IO object

        String inputFileName = args[0];                         // input file name
        IO.InputFile inputFile = pipe.new InputFile();          // create input file object
        inputFile.openInputFile(inputFileName);                 // open pipeline to input file

        String outputFileName = args[1];                        // output file name
        IO.OutputFile outputFile = pipe.new OutputFile();       // create output file object
        outputFile.openOutputFile(outputFileName);              // create pipe to output file

        ArrayList myList = new ArrayList();                     // create list structure

        try                                                     // try to fill myList
        {
            inputFile.readInputFile(myList);
        }
        catch(IllegalArgumentException e)                       // an input value was not valid
        {
            outputFile.writeToOutputFile("Input error.");       // write error to output file
            inputFile.closeInputFile();                         // close input file link
            outputFile.closeOuputFile();                        // close output file link
            System.exit(1);                                     // end program
        }

        MergeSort.sort(myList.getArray(), 0, myList.getSize() - 1); // sort array

        String[] arrayAsString = Utility.arrayToString(myList); // convert array to natural number/symbol representation
        
        outputFile.writeToOutputFile(arrayAsString, inputFile.getFlagFor666()); // write array to output file

        inputFile.closeInputFile();                             // close input file link
        outputFile.closeOuputFile();                            // close output file link
    }  
}
