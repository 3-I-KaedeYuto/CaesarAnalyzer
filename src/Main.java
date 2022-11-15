import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the cipher text.");
        String str = scan.nextLine();
        List<String> result = Caesar.decryptsAll(str);
        System.out.println("[Decrypted texts]");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("key : " + i + " > " + result.get(i));
        }
        scan.close();
    }
}
