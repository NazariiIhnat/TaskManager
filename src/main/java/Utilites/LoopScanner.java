package Utilites;

import java.util.Scanner;

public class LoopScanner {
    private Scanner scanner = new Scanner(System.in);
    private DataVerifier dataVerifier = new DataVerifier();
    private String inputData;

    public String readDate(){
        do {
            inputData = scanner.nextLine();
        }
        while (!dataVerifier.isDate(inputData));
        return inputData;
    }

    public String readDescription() {
        do{
            inputData = scanner.nextLine();
        } while (dataVerifier.isEmptyDescription(inputData));
        return inputData;
    }

    public String readPriority() {
        do{
            inputData = scanner.nextLine();
        } while (!(dataVerifier.isPriorityLetter(inputData)));
        return inputData.toUpperCase();
    }

    public int readID() {
        do {
            inputData = scanner.nextLine();
        } while (!dataVerifier.isNumber(inputData));
        return Integer.parseInt(inputData);
    }
}
