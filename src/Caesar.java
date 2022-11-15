import java.util.ArrayList;
import java.util.List;

/**
 * このクラスはシーザー暗号に関する処理を実装したクラスです。
 */
public class Caesar{
    /**
     * アルファベットの数を示しています。この値は常に26です。
     */
    public static final int alphabets = 26;

    /**
     * 文字列とキーを指定して、シーザー暗号の暗号化処理を行います。
     * キーに0未満を指定した場合、{@code IllegalArgumentException}をスローします。
     * @param source 平文
     * @param key キー
     * @return 暗号文
     * @throws IllegalArgumentException キーの値が不正です。
     */
    public static String encrypt(String source, int key) throws IllegalArgumentException{
        if(key < 0) throw new IllegalArgumentException("Key must be greater than or equal to 0.\nPlease consider to use decrypt method.");
        return shift(source, key);
    }

    /**
     * 文字列とキーを指定して、シーザー暗号の暗号化処理を行います。
     * キーに0未満を指定した場合、{@code IllegalArgumentException}をスローします。
     * @param source 暗号文
     * @param key キー
     * @return 平文
     * @throws IllegalArgumentException キーの値が不正です。
     */
    public static String decrypt(String source, int key) throws IllegalArgumentException{
        if(key < 0) throw new IllegalArgumentException("Key must be greater than or equal to 0.\nPlease consider to use encrypt method.");
        return shift(source, -key);
    }

    public static List<String> encryptsAll(String source){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < alphabets; i++) {
            result.add(encrypt(source, i));
        }
        return result;
    }

    public static List<String> decryptsAll(String source){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < alphabets; i++) {
            result.add(decrypt(source, i));
        }
        return result;
    }

    /**
     * 文字列とキーを指定して、シーザー暗号の変換処理を行います。
     * @param source 変換前の文字列
     * @param key シフトする文字数
     * @return 変換後の文字列
     */
    public static String shift(String source, int key){
        key %= alphabets;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if('A' <= c && c <= 'Z') c = shift(c, key, 'A');
            else if('a' <= c && c <= 'z') c = shift(c, key, 'a');
            result.append(c);
        }
        return result.toString();
    }

    private static char shift(char c, int key, int offset){
        int result = c;
        result += key - offset;
        result %= alphabets;
        if(result < 0) result += alphabets;
        result += offset;
        return (char)result;
    }
}