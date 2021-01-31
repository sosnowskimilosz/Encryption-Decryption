package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class EncDec {

    public List<StringBuilder> initialData;
    public List<StringBuilder> outData = new ArrayList<>();
    public int key;

    EncDec(List<StringBuilder> initialData, int key) {
        this.initialData = initialData;
        this.key = key;
        convert();
    }

    abstract void convert();

    public void showData() {
        for (StringBuilder txt : outData) {
            System.out.println(txt);
        }
    }

    public void saveDataToFile(String nameOfFile) throws IOException {
        File fileWithConvertedFile = new File(nameOfFile);
        FileWriter writer = new FileWriter(fileWithConvertedFile);
        for (StringBuilder lines : outData) {
            writer.write(String.valueOf(lines));
            writer.write("\n");
        }
        writer.close();
    }


}
