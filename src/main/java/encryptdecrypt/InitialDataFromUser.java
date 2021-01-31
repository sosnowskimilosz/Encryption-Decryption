package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InitialDataFromUser {

    String mode = "enc";
    int key = 0;
    List<StringBuilder> textToConvert = new ArrayList<>();
    String fileSource;
    String out="";
    String alg = "shift";

    InitialDataFromUser(String[] dataFromConsole) throws IOException {
        for (int i = 0; i < dataFromConsole.length; i++) {
            switch (dataFromConsole[i]) {
                case "-mode":
                    this.mode = dataFromConsole[i + 1];
                    break;
                case "-data":
                    textToConvert.add(new StringBuilder(dataFromConsole[i + 1]));
                    break;
                case "-key":
                    this.key = Integer.parseInt(dataFromConsole[i + 1]);
                    break;
                case "-in":
                    this.fileSource = dataFromConsole[i + 1];
                    break;
                case "-out":
                    this.out = dataFromConsole[i + 1];
                    break;
                case "-alg":
                    this.alg = dataFromConsole[i + 1];
                    break;
            }
        }
        if (textToConvert.isEmpty()) {
            loadDataFromFile(fileSource);
        }
    }

    public void loadDataFromFile(String nameOfFile) throws IOException {
        File file = new File(nameOfFile);
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            textToConvert.add(new StringBuilder(in.nextLine()));
        }
    }
}
