import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
            String inputFilename = "inputOneTwo.txt";

            int count1 = challengeOne(inputFilename);
            System.out.println("Challenge 1: Number of measurements larger than the previous measurement: " + count1);

            int count2 = challengeTwo(inputFilename);
            System.out.println("Challenge 2: Number of sums larger than the previous sum: " + count2);

            String inputFilename2 = "inputThreeFour.txt";
            int result3 = challengeThree(inputFilename2);
            System.out.println("Challenge 3: Horizontal position multiplied by depth: " + result3);

            int result4 = challengeFour(inputFilename2);
            System.out.println("Challenge 4: Horizontal position multiplied by depth: " + result4);
        }



    /** TODO 1
     *
     * Challenge 1
     *
     * @param inputFilename
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String inputFilename) throws IOException {
        int[] data = readFile(inputFilename);
        int count = 0;

        for (int i = 1; i < data.length; i++) {
            if (data[i] > data[i - 1]) {
                count++;
            }
        }

        return count;
    }


    /** TODO 2
     *
     * Challenge 2
     *
     * @param inputFilename
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String inputFilename) throws FileNotFoundException {
        int[] data = readFile(inputFilename);
        int count = 0;

        for (int i = 2; i < data.length; i++) {
            int sum1 = data[i - 2] + data[i - 1] + data[i];
            int sum2 = data[i - 3] + data[i - 2] + data[i - 1];
            if (sum1 > sum2) {
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param inputFilename2
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String inputFilename2) throws FileNotFoundException {
        String[] commands = readFile(inputFilename2);
        int horizontalPosition = 0;
        int depth = 0;

        for (String command : commands) {
            String[] parts = command.split(" ");
            String action = parts[0];
            int value = Integer.parseInt(parts[1]);

            switch (action) {
                case "forward":
                    horizontalPosition += value;
                    break;
                case "down":
                    depth += value;
                    break;
                case "up":
                    depth -= value;
                    break;
            }
        }

        return horizontalPosition * depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param inputFilename2
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String inputFilename2) throws FileNotFoundException {
        String[] commands = readFile(inputFilename2);
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        for (String command : commands) {
            String[] parts = command.split(" ");
            String action = parts[0];
            int value = Integer.parseInt(parts[1]);

            switch (action) {
                case "forward":
                    horizontalPosition += value;
                    depth += aim * value;
                    break;
                case "down":
                    aim += value;
                    break;
                case "up":
                    aim -= value;
                    break;
            }
        }

        return horizontalPosition * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}
