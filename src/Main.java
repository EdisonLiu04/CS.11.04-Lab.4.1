public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String parentheses) {
        int check = 0;
        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(') {
                check += 1;
            } else {
                check -= 1;
            }
        }
        return check == 0;
    }
    // 2. reverseInteger
    public static String reverseInteger(int myint) {
        String myint_str = Integer.toString(myint);
        StringBuilder ans = new StringBuilder();
        for (int i = myint_str.length() - 1; i >= 0; i--) {
            ans.append(myint_str.charAt(i));
        }

        return ans.toString();
    }
    // 3. encryptThis
    public static String encryptThis(String mystring){
        StringBuilder ans = new StringBuilder();
        int word_start = 0;
        String ascii;
        int offset = 0;
        char temp;

        for (int i = 0; i <= mystring.length(); i++) {
            if (i == mystring.length() || mystring.charAt(i) == ' ') {
                temp = mystring.charAt(word_start - offset + 1);
                ans.replace(word_start + 1, word_start + 2, Character.toString(mystring.charAt(i - 1)));
                ans.replace(i + offset - 1, i + offset, Character.toString(temp));
                ascii = Integer.toString(mystring.charAt(word_start - offset));
                ans.replace(word_start, word_start + 1, ascii);
                offset += (ascii.length() - 1);

                word_start = i + offset + 1; // account for space character & ascii number length
            }

            if (i < mystring.length()) ans.append(mystring.charAt(i));
        }

        return ans.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String decipher){
        StringBuilder ans = new StringBuilder();
        StringBuilder ascii = new StringBuilder();
        int word_len = 0;
        char last = 'a';
        int offset = 0;
        int second;

        for (int i = 0; i <= decipher.length(); i++) {
            if (i == decipher.length() || decipher.charAt(i) == ' ') {
                second = i - offset - word_len;
                ans.replace(second, second + 1, Character.toString(decipher.charAt(i - 1)));
                ans.replace(i - offset - 1, i - offset, Character.toString(last));

                word_len = -1;
            }

            if (word_len == 0) {
                if (Character.isDigit(decipher.charAt(i))) {
                    ascii.append(decipher.charAt(i));
                    offset++;
                } else {
                    offset--;
                    ans.append((char) Integer.valueOf(ascii.toString()).intValue());
                    ascii.setLength(0);
                    word_len++;
                    last = decipher.charAt(i);
                    ans.append(decipher.charAt(i));
                }
            } else if (i < decipher.length()) {
                ans.append(decipher.charAt(i));
                word_len++;
            }
        }

        return ans.toString();
    }
}


