package Date_04_07_25;

public class FindtheK_thCharacterinStringGameII3307 {
    public static void main(String[] args) {
        int k = 10;
        int[] operations = {0,1,0,1};
        System.out.println(new FindtheK_thCharacterinStringGameII3307().kthCharacter(k, operations));
        System.out.println(new FindtheK_thCharacterinStringGameII3307().kthCharacter1(k, operations));
    }
    public static char kthCharacter(long k, int[] operations){
        String word = "a";
        for (int i : operations){
            if (i == 1){
                String nextString = "";
            for (char ch : word.toCharArray()){
                char nextChar;
                if (ch != 'z'){
                    int n = (int)ch;
                    nextChar = (char)(n + 1);
                }
                else{
                    nextChar = 'a';
                }
                nextString += String.valueOf(nextChar);
            }
            word += nextString;
            }
            else{
                word += word;
            }
        }
        return word.charAt((int) (k - 1));
    }

    public static char kthCharacter1(long k, int[] operations){
        StringBuilder word = new StringBuilder();
        word.append("a");

        for (int operation : operations){
            int len = word.length();

            if (operation == 1){
                StringBuilder nextString = new StringBuilder();
                for (int i = 0; i < len; i++){
                    char c = word.charAt(i);
                    char nextChar = (c == 'z') ? 'a' : (char)(c + 1);
                    nextString.append(nextChar);
                }
                word.append(nextString);
            }
            else{
                word.append(word);
            }
        }
        return word.charAt((int) (k - 1));
    }
}
