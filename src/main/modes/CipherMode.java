package main.modes;

public enum CipherMode {
    ENCRYPT,
    DECRYPT,
    BRUTE_FORCE;

    public static CipherMode initializeMode(String mode) {
        CipherMode chooseMode = switch (mode) {
            case "ENCRYPT" -> CipherMode.ENCRYPT;
            case "DECRYPT" -> CipherMode.DECRYPT;
            case "BRUTE_FORCE" -> CipherMode.BRUTE_FORCE;
            default -> throw new IllegalArgumentException("Choose MODE from this list: ENCRYPT/DECRYPT/BRUTE_FORCE");
        };
        return chooseMode;
    }

}
