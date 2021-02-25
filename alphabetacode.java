import java.io.*; 
  
class alphabetacode{ 
static int MAX = 100000; 
static int MIN = -100000; 
static int minimax(int depth, int nodeIndex, Boolean maximizingPlayer, int inputvalues[], int alpha, int beta) 
{
    if (depth == 3) 
        return inputvalues[nodeIndex]; 
  
    if (maximizingPlayer) 
    { 
        int best = MIN;  
        for (int i = 0; i < 2; i++) 
        { 
            int val = minimax(depth + 1, nodeIndex * 2 + i, false, inputvalues, alpha, beta); 
            best = Math.max(best, val); 
            alpha = Math.max(alpha, best); 
            if (beta <= alpha) 
                break; 
        } 
        return best; 
    } 
    else
    { 
        int best = MAX; 
        for (int i = 0; i < 2; i++) 
        { 
            int val = minimax(depth + 1, nodeIndex * 2 + i, true, inputvalues, alpha, beta); 
            best = Math.min(best, val); 
            beta = Math.min(beta, best); 
            if (beta <= alpha) 
                break; 
        } 
        return best; 
    } 
} 
public static void main (String[] args) 
{
        int inputvalues[] = {4,7,8,1,13,2,3,2}; 
        System.out.println("The optimal value is : " + minimax(0, 0, true, inputvalues, MIN, MAX)); 
      
    } 
}