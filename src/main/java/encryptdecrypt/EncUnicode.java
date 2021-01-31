package encryptdecrypt;

import java.util.List;

public class EncUnicode extends EncDec{

    EncUnicode(List<StringBuilder> initialData, int key) {
        super(initialData, key);
    }

    @Override
    void convert() {
        for(int j=0;j<initialData.size();j++) {
            super.outData.add(new StringBuilder(""));
            for (int i = 0; i < super.initialData.get(j).length(); i++) {
                super.outData.get(j).append(printLetter(super.initialData.get(j).charAt(i), super.key));
            }
        }
    }

    public char printLetter(char letter, int key) {
        if (letter + key > 126) {
            return((char) (letter - 95 + key));
        } else {
            return((char) (letter + key));
        }
    }
}
