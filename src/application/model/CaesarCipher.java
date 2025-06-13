package application.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Encrypts and decrypts the given text using Caesar cipher with the specified shift.
 * Supports English and Russian alphabets with case preservation.
 * Non-alphabetic characters remain unchanged.
 */

public class CaesarCipher {
    private static final String ENGLISH_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ENGLISH_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String RUSSIAN_UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String RUSSIAN_LOWER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    private static final Map<Character, Integer> ENGLISH_UPPER_MAP = new HashMap<>();
    private static final Map<Character, Integer> ENGLISH_LOWER_MAP = new HashMap<>();
    private static final Map<Character, Integer> RUSSIAN_UPPER_MAP = new HashMap<>();
    private static final Map<Character, Integer> RUSSIAN_LOWER_MAP = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        for (int i = 0; i < ENGLISH_UPPER.length(); i++) {
            ENGLISH_UPPER_MAP.put(ENGLISH_UPPER.charAt(i), i);
        }
        for (int i = 0; i < ENGLISH_LOWER.length(); i++) {
            ENGLISH_LOWER_MAP.put(ENGLISH_LOWER.charAt(i), i);
        }
        for (int i = 0; i < RUSSIAN_UPPER.length(); i++) {
            RUSSIAN_UPPER_MAP.put(RUSSIAN_UPPER.charAt(i), i);
        }
        for (int i = 0; i < RUSSIAN_LOWER.length(); i++) {
            RUSSIAN_LOWER_MAP.put(RUSSIAN_LOWER.charAt(i), i);
        }
    }

    //encrypts the given text
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (ENGLISH_UPPER_MAP.containsKey(c)) {
                result.append(shiftChar(c, shift, ENGLISH_UPPER, ENGLISH_UPPER_MAP));
            } else if (ENGLISH_LOWER_MAP.containsKey(c)) {
                result.append(shiftChar(c, shift, ENGLISH_LOWER, ENGLISH_LOWER_MAP));
            } else if (RUSSIAN_UPPER_MAP.containsKey(c)) {
                result.append(shiftChar(c, shift, RUSSIAN_UPPER, RUSSIAN_UPPER_MAP));
            } else if (RUSSIAN_LOWER_MAP.containsKey(c)) {
                result.append(shiftChar(c, shift, RUSSIAN_LOWER, RUSSIAN_LOWER_MAP));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    //decrypts the given text
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    //shifting characters
    private static char shiftChar(char c, int shift, String alphabet, Map<Character, Integer> charMap) {
        int len = alphabet.length();
        shift = shift % len;
        if (shift < 0) {
            shift += len;
        }

        int position = charMap.get(c);
        int newPos = (position + shift) % len;
        return alphabet.charAt(newPos);
    }

    //attempts to decrypt the given text by trying all possible shifts
    public static void autoDecrypt(String text) {
        int maxAttempts = RUSSIAN_UPPER.length();

        for (int i = 1; i <= maxAttempts; i++) {
            String decrypted = decrypt(text, i);
            System.out.println("Shift: " + i + "; " + decrypted);
        }
    }
}
