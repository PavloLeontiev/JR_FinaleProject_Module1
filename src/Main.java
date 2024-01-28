import main.utils.Menu;
import main.encryption.Cipher;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        Menu.validationCipherData(cipher, args);
        cipher.execute();
        Menu.openModifyFile(cipher);
    }
}