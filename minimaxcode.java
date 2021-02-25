import java.io.*; 
  
class minimaxcode{

static int minimax(int depth, int nodeIndex, boolean  isMax,  int inputvalues[], int h) 
{ 
    if (depth == h){
        System.out.print(inputvalues[nodeIndex]+" ");
        return inputvalues[nodeIndex]; 
    }

    if (isMax){
        int first = minimax(depth+1, nodeIndex*2,false, inputvalues, h);
        int second = minimax(depth+1, nodeIndex*2 + 1, false, inputvalues, h);
        int flag =  Math.max(first, second); 
        System.out.println("Compairing "+first+" and "+second+" we get "+flag+" in maximizers turn.");
        return flag;
    } 

    else{
        int first = minimax(depth+1, nodeIndex*2, true, inputvalues, h);
        int second = minimax(depth+1, nodeIndex*2 + 1, true, inputvalues, h);
        int flag =  Math.min(first, second); 
        System.out.println("Compairing "+first+" and "+second+" we get "+flag+" in minimizers turn.");
        return flag;
    }
}     

static int log2(int n) 
{ 
return (n==1)? 0 : 1 + log2(n/2); 
} 
  
public static void main (String[] args) {
    int inputvalues[] = {2,5,6,7,14,5,3,7}; 
    int n = inputvalues.length; 
    int h = log2(n); 
    System.out.println("The DFS minimax algorithm goes as follows : ");
    int res = minimax(0, 0, true, inputvalues, h); 
    System.out.println( "The optimal value is : "  +res);  
          
    } 
} 