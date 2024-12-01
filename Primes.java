public class Primes {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        boolean[] primeArray = new boolean [N + 1];
        int count = N - 1;
        int p = 2;
        // initialize the array
        for (int i = 2; i <= N; i++) {
            primeArray[i]= true;
        }
        // Sieve of Eratosthenes 
        while (Math.sqrt(N) >= p)  {
            if (primeArray[p]) {
                int multiple = p * p;
                while (multiple <= N) {
                    if (primeArray[multiple]) {
                        primeArray[multiple] = false;
                        count --; // Reduce count of primes for the percentage calc
                        
                    }
                    multiple += p;
                }
            }
            p++;
        }
        System.out.println( "Prime numbers up to " + N + ":" );
        int i = 2;
        while (i <= N) {
            if (primeArray[i]) {
                System.out.println(i);
            }
            i++;
        }
        int percentage = (int) (((double) count / N) * 100);
        System.out.println("There are " + count + " primes between 2 and " + N + " (" + percentage + "% are primes)");
        }
    }
       
            
        

        

    
