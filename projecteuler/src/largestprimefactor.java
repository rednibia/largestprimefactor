/*
 The prime factors of 13195 are 5, 7, 13 and 29.
 What is the largest prime factor of the number 600851475143 ?
 */

public class largestprimefactor {

    public static void display(int[] list, int thesize) {

        for (int i = 0; i < thesize; i++)
        {
            if(list[i] > 0)
                System.out.println(list[i]);
            else
                break;
        }
    }

    public static boolean ifcontains(int[] list, int thesize, long number)
    {
        for (int i = 0; i < thesize; i++)
        {
            if(list[i] == number)
                return true;
        }
        return false;

    }

    public static int count(int[] list, int thesize) {
        int counter = 0;
        for (int i = 0; i < thesize; i++)
        {
        if(list[i] > 0)
            counter++;
        }
        return counter;
    }

    public static int[] primegen(int howmany){
        int[] Primes = new int[howmany];
        Primes[0] = 2;
        Primes[1] = 3;
        Primes[2] = 5;
        int divident = 7;
        while(count(Primes, howmany) < howmany)
        {
            boolean flag = true;
            for(int i = 0; i < count(Primes, howmany); i++)
            {
                if(divident % Primes[i] == 0)
                {
                flag = false;
                break;
                }
            }
            if(flag == true) {
                Primes[count(Primes, howmany)] = divident;
            }
            divident++;
        }
        return Primes;
    }

    public static void main(String[] args) {

        long starting = 600851475143L;
        int howmany = 1000;
        int[] primes = primegen(howmany);
        int primei = 0;
        while(ifcontains(primes, howmany, starting) == false)
        {
            while(starting % primes[primei] == 0)
                starting = starting / primes[primei];
            primei++;
        }
        System.out.println(starting);
    }
}
