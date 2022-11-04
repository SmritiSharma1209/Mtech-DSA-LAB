package DSA_Lab;

public class KMP_Algo {
	
	void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
 
       
        int pi[] = new int[M];
        int j = 0; // index for pat[]
 
        
        computepiArray(pat, M, pi);
 
        int i = 0; // index for txt[]
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                                + "at index " + (i - j));
                j = pi[j - 1];
            }
 
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = pi[j - 1];
                else
                    i = i + 1;
            }
        }
    }
 
    void computepiArray(String pat, int M, int pi[])
    {
        // length of the previous prefix 
        int len = 0;
        int i = 1;
        pi[0] = 0; // pi[0] is always 0
 
        // the loop calculates pi[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                pi[i] = len;
                i++;
            }
            else      // (pat[i] != pat[len])
            {
                
                if (len != 0) {
                    len = pi[len - 1];
 
                }
                else // if (len == 0)
                {
                    pi[i] = len;
                    i++;
                }
            }
        }
    }

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP_Algo().KMPSearch(pat, txt);

	}

}

//Array
//Linklist Singly doubly 
//BST
//Stack LL
//Queue Singly LL
//Graph (DFS, BFS)
//RMP
//KMP
//Counting Inversions
//Integer Multiplication
