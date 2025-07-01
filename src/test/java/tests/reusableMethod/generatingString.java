package tests.reusableMethod;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class generatingString {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LENGTH = 4;
    private static final Set<String> generated = new HashSet<>();
    private static final Random random = new Random();

    public static String generateUniqueCode() {
        if (generated.size() >= Math.pow(ALPHABET.length(), LENGTH)) {
            throw new RuntimeException("Semua kombinasi sudah habis.");
        }

        String code;
        do {
            StringBuilder sb = new StringBuilder(LENGTH);
            for (int i = 0; i < LENGTH; i++) {
                sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
            code = sb.toString();
        } while (generated.contains(code));

        generated.add(code);
        return code;
    }

}
