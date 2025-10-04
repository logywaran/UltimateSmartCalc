import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> history = new ArrayList<>();
    static Random rand = new Random();

    // -------------------- Math Functions --------------------
    static double add(double a, double b){ return a+b; }
    static double subtract(double a, double b){ return a-b; }
    static double multiply(double a, double b){ return a*b; }
    static double divide(double a, double b){ if(b==0){ System.out.println("⚠️ Cannot divide by zero!"); return Double.NaN;} return a/b; }
    static double remainder(double a, double b){ if(b==0){ System.out.println("⚠️ Cannot divide by zero!"); return Double.NaN;} return a%b; }
    static double percentage(double a, double b){ if(b==0){ System.out.println("⚠️ Cannot divide by zero!"); return Double.NaN;} return (a/b)*100; }
    static double square(double a){ return a*a; }
    static double squareRoot(double a){ if(a<0){ System.out.println("⚠️ Cannot take square root of negative number!"); return Double.NaN;} return Math.sqrt(a); }
    static double cube(double a){ return a*a*a; }
    static double cubeRoot(double a){ return Math.cbrt(a); }
    static double power(double a,double b){ return Math.pow(a,b); }
    static long factorial(int n){ if(n<0){ System.out.println("⚠️ Cannot calculate factorial of negative number!"); return -1; } long f=1; for(int i=1;i<=n;i++) f*=i; return f; }
    static boolean isPrime(int n){ if(n<2) return false; for(int i=2;i*i<=n;i++) if(n%i==0) return false; return true; }

    // -------------------- Statistics --------------------
    static double mean(double[] arr){ double sum=0; for(double x:arr) sum+=x; return sum/arr.length; }
    static double median(double[] arr){ Arrays.sort(arr); int n=arr.length; return (n%2==0) ? (arr[n/2-1]+arr[n/2])/2 : arr[n/2]; }

    static double mode(double[] arr){
        int n = arr.length;
        int maxCount = 0;
        double mode = arr[0];
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(arr[j]==arr[i]) count++;
            }
            if(count>maxCount){
                maxCount = count;
                mode = arr[i];
            }
        }
        return mode;
    }

    static double standardDeviation(double[] arr){ double m=mean(arr), sum=0; for(double x:arr) sum+=(x-m)*(x-m); return Math.sqrt(sum/arr.length); }

    // -------------------- Length Conversions --------------------
    static void lengthConversions(){
        boolean conv=true;
        while(conv){
            System.out.println("\n📏 --- Length Conversions ---");
            System.out.println("1. km → m / miles / yards");
            System.out.println("2. m → km / miles / yards");
            System.out.println("3. miles → km / m / yards");
            System.out.println("4. yards → km / m / miles");
            System.out.println("0. Back");
            System.out.print("Enter choice: "); int choice=sc.nextInt();
            System.out.print("Enter value: "); double val=sc.nextDouble();
            switch(choice){
                case 1:
                    System.out.println(val+" km = "+(val*1000)+" m");
                    System.out.println(val+" km = "+(val*0.621371)+" miles");
                    System.out.println(val+" km = "+(val*1093.61)+" yards");
                    history.add(val+" km converted to m/miles/yards");
                    break;
                case 2:
                    System.out.println(val+" m = "+(val/1000)+" km");
                    System.out.println(val+" m = "+(val/1609.34)+" miles");
                    System.out.println(val+" m = "+(val*1.09361)+" yards");
                    history.add(val+" m converted to km/miles/yards");
                    break;
                case 3:
                    System.out.println(val+" miles = "+(val/0.621371)+" km");
                    System.out.println(val+" miles = "+(val*1609.34)+" m");
                    System.out.println(val+" miles = "+(val*1760)+" yards");
                    history.add(val+" miles converted to km/m/yards");
                    break;
                case 4:
                    System.out.println(val+" yards = "+(val/1093.61)+" km");
                    System.out.println(val+" yards = "+(val/1.09361)+" m");
                    System.out.println(val+" yards = "+(val/1760)+" miles");
                    history.add(val+" yards converted to km/m/miles");
                    break;
                case 0: conv=false; break;
                default: System.out.println("⚠️ Invalid choice!");
            }
        }
    }

    // -------------------- BMI --------------------
    static void bmiCalculator(){
        System.out.print("Enter weight in kg: "); double w=sc.nextDouble();
        System.out.print("Enter height in meters: "); double h=sc.nextDouble();
        double bmi=w/(h*h);
        System.out.println("🩺 Your BMI = "+bmi);
        history.add("BMI calculated: weight="+w+"kg, height="+h+"m, BMI="+bmi);
    }

    // -------------------- Currency Conversion --------------------
    static void currencyConversion(){
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 83.0); // 1 USD = 83 INR
        rates.put("EUR", 90.0); // 1 EUR = 90 INR
        rates.put("GBP", 105.0); // 1 GBP = 105 INR

        boolean conv=true;
        while(conv){
            System.out.println("\n💱 --- Currency Conversion ---");
            System.out.println("1. INR → USD/EUR/GBP");
            System.out.println("2. USD/EUR/GBP → INR");
            System.out.println("0. Back");
            System.out.print("Enter choice: "); int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter INR amount: "); double inr=sc.nextDouble();
                    System.out.println("USD: "+(inr/rates.get("USD")));
                    System.out.println("EUR: "+(inr/rates.get("EUR")));
                    System.out.println("GBP: "+(inr/rates.get("GBP")));
                    history.add(inr+" INR converted to USD/EUR/GBP");
                    break;
                case 2:
                    System.out.print("Enter amount: "); double amt=sc.nextDouble();
                    System.out.print("Currency (USD/EUR/GBP): "); String cur=sc.next().toUpperCase();
                    if(rates.containsKey(cur)){
                        System.out.println(amt+" "+cur+" = "+(amt*rates.get(cur))+" INR");
                        history.add(amt+" "+cur+" converted to INR");
                    } else System.out.println("⚠️ Invalid currency!");
                    break;
                case 0: conv=false; break;
                default: System.out.println("⚠️ Invalid choice!");
            }
        }
    }

    // -------------------- Games --------------------
    static void randomNumberGenerator(){
        System.out.print("Enter min value: "); int min=sc.nextInt();
        System.out.print("Enter max value: "); int max=sc.nextInt();
        if(max<min){ System.out.println("⚠️ Max should be >= Min"); return; }
        int r=rand.nextInt(max-min+1)+min;
        System.out.println("🎲 Random Number: "+r);
        history.add("Random Number between "+min+" and "+max+" = "+r);
    }

    static void guessTheNumber(){
        int secret=rand.nextInt(100)+1;
        System.out.println("Guess a number between 1 and 100");
        int guess=0;
        while(guess!=secret){
            System.out.print("Enter guess: "); guess=sc.nextInt();
            if(guess<secret) System.out.println("🔼 Higher!");
            else if(guess>secret) System.out.println("🔽 Lower!");
            else System.out.println("✅ Correct! The number was "+secret);
        }
        history.add("Guess the Number game played. Number was "+secret);
    }

    static void rockPaperScissors() {
        String[] options = {"Rock", "Paper", "Scissors"};
        int computerChoice = rand.nextInt(3);
        System.out.println("Enter your choice: 0-Rock, 1-Paper, 2-Scissors");
        int userChoice = sc.nextInt();
        if(userChoice<0 || userChoice>2){ System.out.println("⚠️ Invalid choice!"); return; }

        System.out.println("You chose: "+options[userChoice]);
        System.out.println("Computer chose: "+options[computerChoice]);

        if(userChoice==computerChoice){
            System.out.println("🤝 It's a tie!");
            history.add("RPS: Tie. You and Computer chose "+options[userChoice]);
        } else if((userChoice==0 && computerChoice==2) || (userChoice==1 && computerChoice==0) || (userChoice==2 && computerChoice==1)){
            System.out.println("🏆 You win!");
            history.add("RPS: You won. You: "+options[userChoice]+", Computer: "+options[computerChoice]);
        } else{
            System.out.println("💻 Computer wins!");
            history.add("RPS: Computer won. You: "+options[userChoice]+", Computer: "+options[computerChoice]);
        }
    }

    // -------------------- History --------------------
    static void viewHistory(){
        System.out.println("\n📜 --- History ---");
        if(history.isEmpty()){
            System.out.println("No history available.");
        } else{
            for(String h: history) System.out.println(h);
        }
    }

    // -------------------- Input Array --------------------
    static double[] inputArray(){
        System.out.print("Enter number of elements: "); int n=sc.nextInt();
        double[] arr=new double[n];
        for(int i=0;i<n;i++){ System.out.print("Enter element "+(i+1)+": "); arr[i]=sc.nextDouble(); }
        return arr;
    }

    // -------------------- Menus --------------------
    public static void main(String[] args){
        boolean running=true;
        while(running){
            System.out.println("\n==============================");
            System.out.println("🧮 Ultimate SmartCalc v2");
            System.out.println("1. Math Operations ➕➖✖️➗");
            System.out.println("2. Games & Fun 🎮");
            System.out.println("3. Conversions & Health 🧪");
            System.out.println("4. View History 📜");
            System.out.println("0. Exit ❌");
            System.out.print("Enter your choice: "); int mainChoice=sc.nextInt();

            switch(mainChoice){
                case 1: mathMenu(); break;
                case 2: gamesMenu(); break;
                case 3: conversionsHealthMenu(); break;
                case 4: viewHistory(); break;
                case 0: running=false; System.out.println("🙏 Thanks for using Ultimate SmartCalc!"); break;
                default: System.out.println("⚠️ Invalid choice!");
            }
        }
    }

    static void mathMenu(){
        boolean mathMenu=true;
        while(mathMenu){
            System.out.println("\n--- Math Operations ---");
            System.out.println("1. Addition ➕"); System.out.println("2. Subtraction ➖"); System.out.println("3. Multiplication ✖️");
            System.out.println("4. Division ➗"); System.out.println("5. Remainder %"); System.out.println("6. Percentage");
            System.out.println("7. Square"); System.out.println("8. Square Root"); System.out.println("9. Cube");
            System.out.println("10. Cube Root"); System.out.println("11. Power (x^y)"); System.out.println("12. Factorial");
            System.out.println("13. Prime Number Checker"); System.out.println("14. Statistics 📊"); System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: "); int choice=sc.nextInt();

            double num1=0,num2=0,result=0; String record="";
            if(choice>=1 && choice<=6){ System.out.print("Enter first number: "); num1=sc.nextDouble(); System.out.print("Enter second number: "); num2=sc.nextDouble(); }
            else if(choice>=7 && choice<=11){ System.out.print("Enter number: "); num1=sc.nextDouble(); if(choice==11){ System.out.print("Enter power: "); num2=sc.nextDouble(); } }
            else if(choice==12 || choice==13){ System.out.print("Enter integer: "); num1=sc.nextInt(); }
            else if(choice==14){ statisticsMenu(); continue; }
            else if(choice==0){ mathMenu=false; continue; }
            else{ System.out.println("⚠️ Invalid choice!"); continue; }

            switch(choice){
                case 1: result=add(num1,num2); record=num1+" + "+num2+" = "+result; break;
                case 2: result=subtract(num1,num2); record=num1+" - "+num2+" = "+result; break;
                case 3: result=multiply(num1,num2); record=num1+" * "+num2+" = "+result; break;
                case 4: result=divide(num1,num2); record=num1+" / "+num2+" = "+result; break;
                case 5: result=remainder(num1,num2); record=num1+" % "+num2+" = "+result; break;
                case 6: result=percentage(num1,num2); record=num1+"% of "+num2+" = "+result; break;
                case 7: result=square(num1); record="Square of "+num1+" = "+result; break;
                case 8: result=squareRoot(num1); record="Square root of "+num1+" = "+result; break;
                case 9: result=cube(num1); record="Cube of "+num1+" = "+result; break;
                case 10: result=cubeRoot(num1); record="Cube root of "+num1+" = "+result; break;
                case 11: result=power(num1,num2); record=num1+" ^ "+num2+" = "+result; break;
                case 12: long fact=factorial((int)num1); record="Factorial of "+(int)num1+" = "+fact; break;
                case 13: boolean prime=isPrime((int)num1); record=(int)num1 + (prime ? " is prime ✅" : " is not prime ❌"); break;
            }
            if(!record.equals("")){ System.out.println(record); history.add(record); }
        }
    }

    static void statisticsMenu(){
        boolean statsMenu=true;
        while(statsMenu){
            System.out.println("\n--- Statistics 📊 ---");
            System.out.println("1. Mean"); System.out.println("2. Median"); System.out.println("3. Mode");
            System.out.println("4. Standard Deviation"); System.out.println("0. Back");
            System.out.print("Enter your choice: "); int choice=sc.nextInt();
            if(choice==0){ statsMenu=false; continue; }
            double[] arr = inputArray();
            double res=0;
            String record="";
            switch(choice){
                case 1: res=mean(arr); record="Mean = "+res; break;
                case 2: res=median(arr); record="Median = "+res; break;
                case 3: res=mode(arr); record="Mode = "+res; break;
                case 4: res=standardDeviation(arr); record="Standard Deviation = "+res; break;
                default: System.out.println("⚠️ Invalid choice!"); continue;
            }
            System.out.println(record); history.add(record);
        }
    }

    static void gamesMenu(){
        boolean games=true;
        while(games){
            System.out.println("\n--- Games & Fun 🎮 ---");
            System.out.println("1. Random Number Generator 🎲"); System.out.println("2. Guess the Number Game"); System.out.println("3. Rock-Paper-Scissors ✂️📄🪨"); System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: "); int choice=sc.nextInt();
            switch(choice){
                case 1: randomNumberGenerator(); break;
                case 2: guessTheNumber(); break;
                case 3: rockPaperScissors(); break;
                case 0: games=false; break;
                default: System.out.println("⚠️ Invalid choice!");
            }
        }
    }

    static void conversionsHealthMenu(){
        boolean conv=true;
        while(conv){
            System.out.println("\n--- Conversions & Health 🧪 ---");
            System.out.println("1. Length Conversions 📏");
            System.out.println("2. BMI Calculator 🩺");
            System.out.println("3. Currency Conversion 💱");
            System.out.println("0. Back");
            System.out.print("Enter your choice: "); int choice=sc.nextInt();
            switch(choice){
                case 1: lengthConversions(); break;
                case 2: bmiCalculator(); break;
                case 3: currencyConversion(); break;
                case 0: conv=false; break;
                default: System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}
