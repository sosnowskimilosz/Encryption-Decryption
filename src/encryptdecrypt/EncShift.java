package encryptdecrypt;

import java.util.List;

public class EncShift extends EncDec{

    EncShift(List<StringBuilder> initialData, int key) {
        super(initialData, key);
    }

    public void convert() {
        for(int j=0;j<initialData.size();j++){
            super.outData.add(new StringBuilder(""));
            for(int i=0;i<super.initialData.get(j).length();i++){
                if(isCapitalLetter(super.initialData.get(j).charAt(i))){
                    super.outData.get(j).append(printCapitalLetter(super.initialData.get(j).charAt(i),key));
                }else if(isLowercaseLetter(super.initialData.get(j).charAt(i))){
                    super.outData.get(j).append(printLowercaseLetter(super.initialData.get(j).charAt(i),key));
                }else{
                    super.outData.get(j).append(super.initialData.get(j).charAt(i));
                }
            }
        }
    }

    public boolean isCapitalLetter(char letter) {
        return (letter >= 65 && letter <= 90);
    }

    public boolean isLowercaseLetter(char letter) {
        return (letter >= 97 && letter <= 122);
    }

    public char printLowercaseLetter(char letter, int key) {
        if (letter + key > 122) {
            return ((char) (letter - 26 + key));
        } else {
            return ((char) (letter + key));
        }
    }

    public char printCapitalLetter(char letter, int key) {
        if (letter + key > 90) {
            return ((char) (letter - 26 + key));
        } else {
            return ((char) (letter + key));
        }
    }
}
