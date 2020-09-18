import java.util.*; 
  
public class ProthIsPrime 
{ 
  
static boolean[] prime = new boolean[1000000]; 
  
// Calculate all primes upto n. 
static void SieveOfEratosthenes(int n) 
{ 
    // Initialize all entries it as true. 
    // A value in prime[i] will finally 
    // false if i is Not a prime, else true. 
    for (int i = 1; i <= n + 1; i++) 
        prime[i] = true; 
  
    prime[1] = false; 
  
    for (int p = 2; p * p <= n; p++)  
    { 
  
        // If prime[p] is not changed, 
        // then it is a prime 
        if (prime[p] == true)  
        { 
  
            // Update all multiples of p 
            // greater than or equal to 
            // the square of it numbers 
            // which are multiple of p and are 
            // less than p^2 are already been marked. 
            for (int i = p * p; i <= n; i += p) 
                prime[i] = false; 
        } 
    } 
} 
  
// Utility function to check power of two 
static boolean isPowerOfTwo(int n) 
{ 
    return (n > 0 && (n & (n - 1)) == 0); 
} 
  
// Function to check if the Given 
// number is Proth number or not 
static boolean isProthNumber(int n) 
{ 
  
    int k = 1; 
    while (k < (int)(n / k))  
    { 
  
        // check if k divides n or not 
        if (n % k == 0) 
        { 
  
            // Check if n/k is power of 2 or not 
            if (isPowerOfTwo((int)(n / k))) 
                return true; 
        } 
  
        // update k to next odd number 
        k = k + 2; 
    } 
  
    // If we reach here means there 
    // exists no value of K such 
    // that k is odd number and n/k 
    // is a power of 2 greater than k 
    return false; 
} 
  
// Function to check whether the given 
// number is Proth Prime or Not. 
static boolean isProthPrime(int n) 
{ 
    // Check n for Proth Number 
    if (isProthNumber(n - 1)) 
    { 
  
        // if number is prime, return true 
        if (prime[n]) 
            return true; 
        else
            return false; 
    } 
    else
        return false; 
} 
  
// Driver Code 
public static void main(String args[]) 
{ 
    int n = 25; 
  
    // if number is proth number, 
    // calculate primes upto n 
    SieveOfEratosthenes(n); 
  
    for (int i =1 ; i <= n; i++) 
        // Check n for Proth Prime 
        if (isProthPrime(i)) 
            System.out.println(i +" is Proth Prime");
//        else 
//        	System.out.println("Not a proth prime");
}
} 
  