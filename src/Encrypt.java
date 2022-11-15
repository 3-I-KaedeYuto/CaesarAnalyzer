import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the plain text.");
        String str = scan.nextLine();
        System.out.println("Input the key.");
        int n = Integer.parseInt(scan.nextLine());
        System.out.println("[Cipher text]");
        System.out.println(Caesar.encrypt(str, n));
        scan.close();
    }
}
