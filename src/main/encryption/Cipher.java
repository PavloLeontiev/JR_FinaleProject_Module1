package main.encryption;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Cipher extends UserData {
    public void execute(){
        try {
            int bytesRead = fileChannelRead.read(byteBuffer);
            byte[] bytes = null;
            while (bytesRead != -1) {
                bytes = byteBuffer.array();
                bytes = switch (cipherMode){
                    case ENCRYPT -> cipherAlgorithm.encrypt(bytes, alphabet, key, bytesRead);
                    case DECRYPT -> cipherAlgorithm.decrypt(bytes, alphabet, key, bytesRead);
                    case BRUTE_FORCE -> throw null;
                };
                // Не зрозумів чому не записує у файл при використані byteBuffer = byteBuffer.put(bytes);
                // Тільки через ByteBuffer.wrap(...);
                byteBuffer = ByteBuffer.wrap(bytes, 0, bytesRead);
                fileChannelWrite.write(byteBuffer);
                byteBuffer.clear();
                bytesRead = fileChannelRead.read(byteBuffer);
            }
            fileChannelRead.close();
            fileChannelWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
