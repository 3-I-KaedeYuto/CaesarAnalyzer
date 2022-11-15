import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the cipher text.");
        String str = scan.nextLine();
        System.out.println("Input the key.");
        int n = Integer.parseInt(scan.nextLine());
        System.out.println("[Plain text]");
        System.out.println(Caesar.decrypt(str, n));
        scan.close();
    }
}
