import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 *
 */
public class Solution {

  /*
   *
   */
  static int[] patternSearch(String[] G, String[] P, int startRow, int startCol) {

    // **** ****
    int[] lastCoords = new int[2];

    // // ???? ????
    // System.out.println("patternSearch <<< startRow: " + startRow + " startCol: "
    // + startCol);

    // **** ****
    int r = P.length;
    int c = P[0].length();

    // // ???? ????
    // System.out.println("patternSearch <<< r: " + r + " c: " + c);

    // ***** traverse the pattern matching the grid ****
    int row = 0;
    int col = 0;
    for (row = 0; row < r; row++) {

      for (col = 0; col < c; col++) {

        // // ???? ????
        // System.out.println("<<< P[" + row + "].charAt(" + col + "): " +
        // P[row].charAt(col) + " G[" + (startRow + row)
        // + "].charAt(" + (startCol + col) + "): " + G[startRow + row].charAt(startCol
        // + col));

        // **** check if we encountered a mismatch ****
        if (P[row].charAt(col) != G[startRow + row].charAt(startCol + col)) {

          // **** set last graphic coordinates ****
          lastCoords[0] = startRow + row;
          lastCoords[1] = startCol + col;

          // **** return last graphic coordinates ****
          return lastCoords;
        }
      }

    }

    // **** set last graphic coordinates ****
    lastCoords[0] = startRow + row;
    lastCoords[1] = startCol + col;

    // **** return last graphic coordinates ****
    return lastCoords;
  }

  /*
   * Complete the gridSearch function below.
   */
  static String gridSearch(String[] G, String[] P) {

    // **** ****
    int R = G.length;
    int C = G[0].length();

    // // ???? ????
    // System.out.println("gridSearch <<< R: " + R + " C: " + C);

    // **** ****
    int r = P.length;
    int c = P[0].length();

    // // ???? ????
    // System.out.println("gridSearch <<< r: " + r + " c: " + c);

    // **** loop searching for the pattern in the grid ****
    for (int row = 0; row <= R - r; row++) {

      for (int col = 0; col <= C - c; col++) {

        // **** search for the pattern at this location ****
        int[] lastCoords = patternSearch(G, P, row, col);

        // // ???? ????
        // System.out.println("gridSearch <<< lastCoords: [" + lastCoords[0] + ", " +
        // lastCoords[1] + "]");

        // **** check if pattern was found ****
        if ((row + r == lastCoords[0]) && (col + c == lastCoords[1])) {
          return "YES";
        }
      }

    }

    // **** pattern NOT found ****
    return "NO";
  }

  // **** open scanner ****
  private static final Scanner scanner = new Scanner(System.in);

  /*
   * Test scaffolding.
   */
  public static void main(String[] args) throws IOException {

    // **** ****
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    // **** read the number of test cases ****
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // // ???? ????
    // System.out.println("main <<< t: " + t);

    // **** loop once per test case ****
    for (int tItr = 0; tItr < t; tItr++) {

      // **** read and extract the number or rows and columns for the grid ****
      String[] RC = scanner.nextLine().split(" ");
      int R = Integer.parseInt(RC[0]);
      int C = Integer.parseInt(RC[1]);

      // // ???? ????
      // System.out.println("main <<< R: " + R + " C: " + C);

      // **** read the grid ****
      String[] G = new String[R];
      for (int i = 0; i < R; i++) {
        String GItem = scanner.nextLine();
        G[i] = GItem;
      }

      // **** read and extract the number or rows and columns for the pattern ****
      String[] rc = scanner.nextLine().split(" ");
      int r = Integer.parseInt(rc[0]);
      int c = Integer.parseInt(rc[1]);

      // // ???? ????
      // System.out.println("main <<< r: " + r + " c: " + c);

      // **** read the pattern ****
      String[] P = new String[r];
      for (int i = 0; i < r; i++) {
        String PItem = scanner.nextLine();
        P[i] = PItem;
      }

      // **** search for the pattern in the grid ****
      String result = gridSearch(G, P);

      // **** ****
      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    // **** close the output stream ****
    bufferedWriter.close();

    // **** close the scanner ****
    scanner.close();
  }

}