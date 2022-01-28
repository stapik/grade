package leetcode;

public class PalindromeEasy {

    public boolean isPalindrome(int x) {
        String val = String.valueOf(x);
        char[] symbols = val.toCharArray();
        int l, r;

        if(symbols[0] == '-'){
            return false;
        }

        for(l=0; l < symbols.length; l++){
            r = symbols.length - l - 1;

            if(r == l){
                break;
            }

            if(symbols[l] != symbols[r]){
                return false;
            }
        }

        return true;
    }
}
