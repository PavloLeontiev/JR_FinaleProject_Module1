package main.modes;

import java.util.ArrayList;
import java.util.Arrays;

public enum CipherMode {
    ENCRYPT,
    DECRYPT,
    BRUTE_FORCE;
    public static final ArrayList<CipherMode> modes = new ArrayList<>(Arrays.asList(ENCRYPT, DECRYPT, BRUTE_FORCE));
    public static CipherMode initializeMode(String mode) {
        return switch (mode) {
            case "ENCRYPT" -> CipherMode.ENCRYPT;
            case "DECRYPT" -> CipherMode.DECRYPT;
            case "BRUTE_FORCE" -> CipherMode.BRUTE_FORCE;
            default -> throw new IllegalArgumentException("Choose MODE from this list: ENCRYPT/DECRYPT/BRUTE_FORCE");
        };
    }

}
