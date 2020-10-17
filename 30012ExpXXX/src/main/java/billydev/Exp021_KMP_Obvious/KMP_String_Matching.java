package billydev.Exp021_KMP_Obvious;

public class KMP_String_Matching {
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
 
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];   //BL: lps has pattern's length
        int j = 0; // index for pat[]
 
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat,M,lps);
 
        int i = 0; // index for txt[]
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }            
            /**
             * Billy: j is always how many matched so far; if totally matched the pattern, then j will begin from the previous matched "max leftover" 
             *                   if once match partly, then decide not match, then j will return and "i" will stuck wait until j reached "0" 
             *                   even if totally matched, i and j both jump to new one, then i will also wait in new position  until "j" reached to "0"; 
             *        i is always continuously move forward when "match" happen unless "unmatch" happen and i will keep waiting j reach "0" 
             */
            
            if (j == M)
            {
                System.out.println("Found pattern " + "at index "  + (i-j));
                j = lps[j-1]; //BL: once got one fully matched, the next fully match might still begin from the char within the already fully matched one !
                              //BL: although fully match found, but the lps value for last position of pat string might still be 0, that means it could not be "re-used" 
                              //BL: there is also cases when fully matched stuff could be "re-used", then j will have non-zero value
                    
            }
 
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i))  //BL:after j matached, next char not match
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];  //BL: once partly matched, need check the table to see what is longest match for that partly matched string, then this j will be used for next comparison based on "some done match " !!
                else
                    i = i+1;     //BL: j==0 means never partly matched, i move forward only 
            }
        }
    }
 
    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0  //BL: I guess either prefix or suffix is null, so no matched stuff
 
        //BL: i always moves forward, lps[i] records how many chars match could be found within this pattern string !!
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len)) //BL: once we got "internal match" with pattern, then len and i increase at the same time!
            {
                len++;
                lps[i] = len;           //BL: also len will be input as the "matched mark of ith position"
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0)
                {             //BL: this branch means once somewhat matched 
                    len = lps[len-1]; //BL: with no continues match, get the length of "previous max length position" 
 
                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {           //BL: this branch means nothing matched so far ,goting to mark the lps for this "i" to 0 !! 
                    lps[i] = len;
                    i++;    //BL: only i move forward
                }
            }
        }
    }
 
    // Driver program to test above function
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        
       //using pattern in: http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
        txt="BBC ABCDAB ABCDABCDABDE"; 
        pat="ABCDABD";
        
//        // the following added by myself to have multiple matches
//        txt="BBC ABCDAB ABCDABCDABDEYLSDAFABCDABDLJSF"; 
//        pat="ABCDABD";
//        
//        // the following added by myself , the matched one also have prefix match in the matched string!!
        txt="BBC ABCDAB ABCDABCDABCDABCEYLSDAFABCDABDLJSF"; 
        pat="ABCDABC";
        

        
        new KMP_String_Matching().KMPSearch(pat,txt);
    }
}
