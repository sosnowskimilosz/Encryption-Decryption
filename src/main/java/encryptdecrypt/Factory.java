package encryptdecrypt;

import java.util.List;

public class Factory {

    public static EncDec generateConverter(String algType, String modeType, List<StringBuilder> inputData,int key){
        if("unicode".equals(algType) && "dec".equals(modeType)){
            return new DecUnicode(inputData,key);
        }else if("unicode".equals(algType) && "enc".equals(modeType)){
            return new EncUnicode(inputData,key);
        }else if("shift".equals(algType) && "dec".equals(modeType)){
            return new DecShift(inputData,key);
        }else{
            return new EncShift(inputData,key);
        }
    }
}
