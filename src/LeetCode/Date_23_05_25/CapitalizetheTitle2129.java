package LeetCode.Date_23_05_25;

public class CapitalizetheTitle2129 {
    public static void main(String[] args) {
        String title = "capiTalIze tHe titLe";
        System.out.println(new CapitalizetheTitle2129().capitalizeTitle(title));
    }
    public String capitalizeTitle(String title) {
        String[] words = title.toLowerCase().split(" ");
        StringBuilder hello = new StringBuilder();
        for (String word : words){
            char[] str = word.toCharArray();
            str[0] = Character.toUpperCase(str[0]);
            word = String.valueOf(str);
            hello.append(word).append(" ");
        }
        if (hello.length() > 1) hello.setLength(hello.length() - 1);
        return hello.toString();
    }
}
