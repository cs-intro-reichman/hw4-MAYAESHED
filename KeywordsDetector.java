public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
       // compare every sentence with every keyword
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < keywords.length; j++) { 
                if (contains(lowerCase(sentences[i]), lowerCase(keywords[j]))) { // if the lowercase string comparing is true
                    System.out.println(sentences[i]);
                }
            }
        }
        
    }

  /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String lowerString = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lowerString += (char) (ch + 32);
            } else {
                lowerString += ch;
            }
        }
        return lowerString;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        // edge cases
        if (str2.length() == 0) {
            return true;
        } 
        if (str1.length() < str2.length()) {
            return false;
        }
        // finds str2 in sr1
        for (int i = 0; i <= str1.length() - str2.length(); i ++) {
            boolean matchingIndex = true;
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    matchingIndex = false;
                    break;
                } 
            }
            if (matchingIndex) {
                return true;     
            }
        }     
        return false;
    }
}
  

