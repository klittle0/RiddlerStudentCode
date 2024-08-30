import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kate Little
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";
        for (int i = 0; i < encrypted.length(); i++){
            // Get each character of encrypted
            char current = encrypted.charAt(i);
            if (Character.isUpperCase(current)){
                // Caesar shift on uppercase letters
                decrypted += (char)((encrypted.charAt(i) - 'A' + 9) % 26 + 'A');
                }
            else if (Character.isLowerCase(current)){
                // Caesar shift on lowercase letters
                decrypted += (char)((encrypted.charAt(i) - 'a' + 9) % 26 + 'a');
            }
            // Maintains spaces & punctuation, aside from line breaks
            else{
                decrypted += current;
            }
        }
        System.out.println(decrypted);
        return decrypted;
    }


    public String decryptTwo(String encrypted) {
        String decrypted = "";
        // Split the string based on spaces
        String[] encryptedSplit = encrypted.split("\\s+");
        for (int i = 0; i < encryptedSplit.length; i++){
            // Take each segment's ascii value & add the corresponding letter to decrypted
            int current = Integer.valueOf(encryptedSplit[i]);
            decrypted += (char)current;
        }
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";
        for (int i = 0; i < encrypted.length(); i+=8){
            // Take 8-bit segment of encrypted, representing a char
            String segment = encrypted.substring(i, i+8);
            // Convert binary to decimal, then add to decrypted as a char
            decrypted += (char) Integer.parseInt(segment,2);
        }
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";
        for (int i = 0; i < encrypted.length(); i++){
            // Caesar shift to convert each decimal value to ascii alphabet, then add to decrypted
            decrypted += (char) ((int) encrypted.charAt(i) - 9919);
        }
        return decrypted;
    }
}
