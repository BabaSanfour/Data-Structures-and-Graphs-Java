
public class Palindrome {
    /**
     * @param input
     * @return
     */
    public static boolean checker(String input) {
        for (int i=0; i<input.length() / 2; i++) { // Iterate only over half the sentence length; 
            //if the length of the sentence we won't test the charachter in the middle as 
            // it doesnt affect the results
            if (input.charAt(i) != input.charAt(input.length()-i-1)) { // check if input[i] is not the same as input[len-i-1]
                return false; // return false if we have a mismatch
            }
        } 
        // if the loop ends without finding a mismatch we return true 
        return true; 
    }
    /**
     * @param input
     * @return
     */
    public static boolean checker_recursive(String input) {
        // This the recursive funtion stoping condition:
        // If we reach a sub-sentence with length 0 (in the case where
        // the initial length is pair) or 1 (the initial length is impair)
        // that means we didn,t find a mismatch
        if (input.length() == 0 || input.length() == 1){
            return true;
        }
        if (input.charAt(0) == input.charAt(input.length()-1)){
            // Init the subInput, we use it to create a subString of the input
            String subInput ="";
            // create a subString of the input without the first and last two chars
            for (int i = 1; i < input.length() - 1; i++) {
                subInput = subInput + input.charAt(i); // == subInput = input[1->n-1]
            }
            return checker_recursive(subInput); // 
        }
        
        return false;   // If we found a mismatch we return false
    }
    /**
     * @param input
     * @return
     */
    public static String reverse(String input) {
        String newInput =""; // init newInput
        // iterate from length(input) -1 to 0
        for (int i = input.length() - 1; i >= 0; i--) {
            newInput = newInput + input.charAt(i); // add charachters starting from the last one
        }
        return newInput; // a reversed version of the input 
      }
    /**
     * @param input
     * @return
     */
    public static String transforme_palindrome(String input){
        if (checker_recursive(input)){ // check if a sentence is a palindrome
            return input; // if yes return in
        }
        String newInput = reverse(input); // else inverse it using reverse
        return input + newInput; // concat input and new input and reverse them
    }
    public static String transforme_palindrome_compacte(String input){
        if (checker_recursive(input)){ // check if a sentence is a palindrome
            return input; // if yes return in
        }
        for (int i = 1; i<input.length()-1; i++){
            int j = 1;
            // we have to check if we have a palindrome in the middle of the sentence
            while (j < i && input.charAt(j) == input.charAt(input.length() - i + j)) {
                j++;
            }
            if (j==i){ // yes we found a palindrome that starts at i
                // we take the part from 0 to i that is not a palindrome
                String not_palind = "";
                for (int k = 0; k <= i; k++) {
                    not_palind = not_palind + input.charAt(k); // == 
                }
                
                // we return the input with the inversed first part
                return input + reverse(not_palind);
            }

        }

        return input + reverse(input);
    }
    public static void main(String[] args) {
        System.out.println(Palindrome.checker("racecar")); 
        System.out.println(Palindrome.checker_recursive("racecar"));
        System.out.println(Palindrome.reverse("reverse")); 
        System.out.println(Palindrome.transforme_palindrome("qwere")); 
        System.out.println(Palindrome.transforme_palindrome_compacte("qwere"));
    }
    
}
