import java.util.ArrayList;
import java.util.List;

public class MyStringReader {

    public static String readAndWriteString(String str){
        if (checkString(str)){
            return getString(str);
        } else {
            return "Строка не валидна";
        }
    }

    private static String getString (String str){
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i<str.length()){
            if (Character.isDigit(str.charAt(i))){
                int countOfRepeat = Character.digit(str.charAt(i), 10) ;
                i++;
                    String strRec = "";
                    StringBuilder builderRec = new StringBuilder();
                    int check = 0;
                    for (int j = i; j < str.length(); j++) {
                        if (str.charAt(j)=='['){
                            check++;
                        } else if (str.charAt(j)==']'){
                            check--;
                        } else {
                            builderRec.append(str.charAt(j));
                        }
                        if (check == 0){
                            i = j++;
                            strRec = builderRec.toString();
                            break;
                        }
                    }


                    for (int j = 0; j < countOfRepeat; j++) {
                        builder.append(getString(strRec));
                    }
                    i++;
                } else {
                builder.append(str.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }



    public static boolean checkString(String str){
        List<Character> brackets = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='['){
                brackets.add(str.charAt(i));
            }
            try {
                if ( str.charAt(i)==']'){
                    if (brackets.get(brackets.size()-1)!='[') {
                        return false;
                    }
                    brackets.remove(brackets.size()-1);
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }


        }
        if (brackets.size() != 0) {
            return false;
        }
        return true;
    }
}
