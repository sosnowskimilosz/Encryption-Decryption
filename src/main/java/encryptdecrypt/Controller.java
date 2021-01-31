package encryptdecrypt;

import java.io.IOException;

public class Controller {

    public static void main(String[] args) throws IOException {
        //String initText = "-key 5 -alg unicode -in inData.txt -mode dec -out outData.txt";
        String[] tableWithInitText = args;
        InitialDataFromUser initialData = new InitialDataFromUser(tableWithInitText);
        EncDec converter = Factory.generateConverter(initialData.alg, initialData.mode, initialData.textToConvert, initialData.key);
        displayOption(initialData.out, converter);
    }

    public static void displayOption(String outOption, EncDec converter) throws IOException {
        if (outOption.isEmpty()) {
            converter.showData();
        } else {
            converter.saveDataToFile(outOption);
        }
    }
}
