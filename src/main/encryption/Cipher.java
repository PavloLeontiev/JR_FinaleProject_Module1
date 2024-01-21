package main.encryption;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Cipher extends UserData {
    public void execute(){
        try {
            char[] array = new char[128];
            int bytesRead = reader.read(array);
            while (bytesRead != -1) {
                array = switch (cipherMode){
                    case ENCRYPT -> cipherAlgorithm.encrypt(array, alphabet, key, bytesRead);
                    case DECRYPT -> cipherAlgorithm.decrypt(array, alphabet, key, bytesRead);
                    case BRUTE_FORCE -> throw null;
                };
                writer.write(array, 0, bytesRead);
                writer.flush();
                bytesRead = reader.read(array);
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
