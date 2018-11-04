package Utilites;

import java.util.Scanner;

public class LoopScanner {
    private Scanner scanner = new Scanner(System.in);
    private DataVerifier dataVerifier = new DataVerifier();

    public String readDate(){
        String inputData;
        do {
            inputData = scanner.nextLine();
        }
        while (!dataVerifier.isDate(inputData));
        return inputData;
    }

    public String readDescription() {
        String inputData;
        do{
            inputData = scanner.nextLine();
        } while (dataVerifier.isEmptyDescription(inputData));
        return inputData;
    }
}
