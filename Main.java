import java.io.*;
import java.util.*;
 
public class Main {
    int intmin=-(int)1e9;
    int intmax=(int)1e9;
    long longmin=-(long)1e17;
    long longmax=(long)1e17;

    // Writing your solution here. -------------------------------------
    // 1) FIRST READ QUESTION PROPERLY 2 TIMES
    // 2) CHECK FOR LONG
    public void solve(MyScanner sc){
        int n=sc.nextInt();
        
        
        //print("------------------------");
    }
   
    public void brute(MyScanner sc){
        // print("-------------------");
    }
    public static void main(String[] args) throws java.lang.Exception {

        MyScanner sc = new MyScanner();
 
        // int test = sc.nextInt();
        // while (test-->0) {
        //     (new Main()).solve(sc);
        // }
       
        (new Main()).solve(sc);

        /* --- Bruteforce Testing --- */
        // brute(sc);
 
        out.flush();
        out.close();
    }
 
    // -------------- Required Functions ------------------------------------- //
    public boolean isPrime(int n) {
        if (n <= 1)return false;
        if (n == 2 || n == 3)return true;
        if (n % 2 == 0 || n % 3 == 0)return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)return false;
        }
        return true;
    }
    public boolean valid(int n,int m,int i,int j){
        return !(i<0 || j<0 || i>=n || j>=m);
    }
    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    public long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    // TC:- O(nloglogn)
    public List<Integer> getPrimeUpToN(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] visi = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!visi[i]) {
                list.add(i);
                for (long j = (long) i * i; j <= n; j += i) visi[(int) j] = true;
            }
        }
        return list;
    }
    // Use when multiple times requirements of Prime factors (MAXlog(MAX))
    int[]spf;
    public void buildSPF(int MAX) {
        spf=new int[MAX+1];
        for (int i = 2; i <= MAX; i++) spf[i] = i;
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
    }
    // TC:- log(num)
    public List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        while (num > 1) {
            int p = spf[num];
            factors.add(p);   
            num /= p;         // Multiple prime number
            // while(num % p == 0) num/=p;  // Unique prime number
        }
        return factors;
    }
    // Only for single number TC:- O(√n)
    public List<Integer> getPrimeFactorsForSingleNumber(int n){
        List<Integer> fact=new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                fact.add(i);
                n/=i;
            }
        }
        if(n>1)fact.add(n);
        return fact;
    }
    // TC:- O(√n)
    public List<Integer> getDivisors(int x) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (i != x / i) {
                    divisors.add(x / i);
                }
            }
        }
        return divisors;
    }
    public long powerMod(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1)result = (result * base) % mod;
            base = (base * base) % mod;
            exponent >>= 1;  
        }
        return result;
    }
    public long modInverse(long n,long mod) {
        return powerMod(n, mod - 2,mod);
    }
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    public int[] getFrequency(int[] arr) {
        int maxValue=0;
        for(int num:arr)maxValue = Math.max(maxValue,num);
        int[] freq = new int[maxValue + 1];  
        for (int num : arr) freq[num]++;
        return  freq;
    }
    public <T> void swap(T[] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public boolean isSqr(long val) {
        return ((double)Math.sqrt(val)) == ((long)Math.sqrt(val));
    }
    public void print(Object... values) {for (Object value : values)out.print(value + " ");
        out.println();}
    public void print(char val){out.println(val);}
    public void print(long val){out.println(val);}
    public void print(int val){out.println(val);}
    public void print(String val){out.println(val);}
    public void print(StringBuilder sb){out.println(sb);}
    public void print(Long[] arr){for(Long num:arr){out.print(num);out.print(" ");}
        out.println();} 
    public void print(int[] arr){for(int num:arr){out.print(num);out.print(" ");}
        out.println();}
    public void print(long[] arr){for(long num:arr){out.print(num);out.print(" ");}
        out.println();}
    public void print(int[][] arr){for(int[] A:arr){for(int num:A)out.print(num+" ");
        out.println();}}
    public void print(long[][] arr){for(long[] A:arr){for(long num:A)out.print(num+" ");
        out.println();}}
    public void print(char[][] arr){for(char[] A:arr){for(char num:A)out.print(num+" ");
        out.println();}}
    public <T> void print(List<T> list){for(Object num:list){out.print(num);out.print(" ");}
        out.println();}
    public <T> void print(PriorityQueue<T> pq) {PriorityQueue<T> copy = new PriorityQueue<>(pq);  
        out.print("PQ => ");while (!copy.isEmpty()) {out.print(copy.poll());out.print(" ");}
        out.println();}
    public <T> void print(Queue<T> queue){for(Object num:queue){
        out.print(num);out.print(" ");}out.println();}
    public <K, V> void print(HashMap<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet())
            out.println("  " + entry.getKey() + " => " + entry.getValue());}
    public <T> void print(HashSet<T> set){for(Object num:set){
        out.print(num);out.print(" ");}out.println();}
 
    // -------------- Required Classes -------------------------------------//
    public class TrieNodeW{
        TrieNodeW[] next=new TrieNodeW[26];
        String word;
    }
    public class TrieNodeB{
        TrieNodeB[] next=new TrieNodeB[2];
        int num;
    }
    // -----------PrintWriter for faster output------------------------------cmd
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] nextArray(int n){
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=this.nextInt();
            }
            return arr;
        }
        long[] nextArrayL(int n){
            long[] arr=new long[n];
            for (int i = 0; i < n; i++) {
                arr[i]=this.nextLong();
            }
            return arr;
        }
        char[] nextArrayC(int n){
            return nextLine().toCharArray();
        }
        int[][] nextArray2d(int n,int m){
            int[][] arr=new int[n][m];
            for (int i = 0; i < n; i++) {
                for(int j=0;j<m;j++){
                    arr[i][j]=this.nextInt();
                }
            }
            return arr;
        }
    }
}