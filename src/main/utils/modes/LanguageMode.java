package main.utils.modes;

import main.utils.UserData;

public enum LanguageMode {
    ENGLISH,
    UKRAINIAN;

    public static LanguageMode initializeMode(String mode, UserData userData){
        LanguageMode chooseMode = switch (mode) {
            case "ENGLISH" -> LanguageMode.ENGLISH;
            case "UKRAINIAN" -> LanguageMode.UKRAINIAN;
            default -> throw new IllegalArgumentException("Choose MODE from this list: ENGLISH/UKRAINIAN");
        };
        return chooseMode;
    }
}
