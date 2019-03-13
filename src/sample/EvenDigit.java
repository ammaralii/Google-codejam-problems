package sample;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem:
 * Supervin has a unique calculator. This calculator only has a display, a plus button, and a minus button. Currently, the integer N is displayed on the calculator display.
 *
 * Pressing the plus button increases the current number displayed on the calculator display by 1. Similarly, pressing the minus button decreases the current number displayed on the calculator display by 1. The calculator does not display any leading zeros. For example, if 100 is displayed on the calculator display, pressing the minus button once will cause the calculator to display 99.
 *
 * Supervin does not like odd digits, because he thinks they are "odd". Therefore, he wants to display an integer with only even digits in its decimal representation, using only the calculator buttons. Since the calculator is a bit old and the buttons are hard to press, he wants to use a minimal number of button presses.
 *
 * Please help Supervin to determine the minimum number of button presses to make the calculator display an integer with no odd digits.
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each begins with one line containing an integer N: the integer initially displayed on Supervin's calculator.
 *
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the minimum number of button presses, as described above.
 *
 * Limits
 * 1 ≤ T ≤ 100.
 * Time limit: 20 seconds per test set.
 * Memory limit: 1GB.
 *
 * Small dataset (Test set 1 - Visible)
 * 1 ≤ N ≤ 105.
 *
 * Large dataset (Test set 2 - Hidden)
 * 1 ≤ N ≤ 1016.
 *
 * Sample
 *
 * Input    Output
 * 4
 * 42       Case #1: 0
 * 11       Case #2: 3
 * 1        Case #3: 1
 * 2018     Case #4: 2
 *
 * In Sample Case #1, the integer initially displayed on the calculator has no odd digits, so no button presses are needed.
 *
 * In Sample Case #2, pressing the minus button three times will cause the calculator to display 8. There is no way to satisfy the requirements with fewer than three button presses.
 *
 * In Sample Case #3, either pressing the minus button once (causing the calculator to display 0) or pressing the plus button once will cause the calculator to display an integer without an odd digit.
 *
 * In Sample Case #4, pressing the plus button twice will cause the calculator to display 2020. There is no way to satisfy the requirements with fewer than two button presses.
 */
public class EvenDigit {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        for(int i=1;i<=input;i++){
            int number=Integer.parseInt(scanner.nextLine());
            int count1 = ups(number);
            int count2 = downs(number);
            System.out.print("Case #"+i+": ");
            System.out.println(count1<count2? count1:count2);
        }

    }

    public static boolean isOdd(String number){
        if(number.contains("1")||number.contains("3")||number.contains("5")||number.contains("7")||number.contains("9"))
            return true;
        else
            return false;
    }

    public static int ups(int number){
        int count=0;
        boolean flag=true;
        while(flag){
            if(isOdd(String.valueOf(number++))){
                count++;
            }else{
                flag=false;
            }
        }
        return count;
    }

    public static int downs(int number){
        int count=0;
        boolean flag=true;
        while(flag){
            if(isOdd(String.valueOf(number--))){
                count++;
            }else{
                flag=false;
            }
        }
        return count;
    }
}