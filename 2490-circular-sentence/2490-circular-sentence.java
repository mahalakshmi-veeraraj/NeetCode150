class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        
        
        int currentWordLength = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            currentWordLength = currentWord.length();
            if (currentWord.charAt(currentWordLength - 1) != nextWord.charAt(0)) {
                return false;
            } 
        }
        
        char firstCharacterOfFirstWord = words[0].charAt(0);
        String lastWord = words[words.length - 1];
        char lastCharacterOfLastWord = words[words.length - 1].charAt(lastWord.length() - 1);
        
        return firstCharacterOfFirstWord == lastCharacterOfLastWord;
    }
}