package gateway;

public interface Readable {
    /**
     * Reads the file given and stores the lines in an array that is returned.
     * @param fileName name of the file to read
     * @return a String array of the lines in the file
     * @throws Exception file not found
     */
    String[] readFile(String fileName) throws Exception;
}
