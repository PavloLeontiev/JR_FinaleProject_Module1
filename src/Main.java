import main.cli.CLI;
import main.utils.Menu;
import main.encryption.Cipher;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        String[] arg = CLI.getInputArgument();
        Menu.validationCipherData(cipher, arg);
        cipher.execute();

    }
}