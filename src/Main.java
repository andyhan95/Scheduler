import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("Welcome to Scheduler.\nScheduler figures out for you whether you have enough time for your leisure activities or not.");
        System.out.println("What is your name?");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        System.out.println("How many hours of free time do you have today?");
        Scanner timeScanner = new Scanner(System.in);
        int time = timeScanner.nextInt();
        System.out.println("Initializing profile...\nDone");

        User user = new User(name, time);

        System.out.println("Welcome " + user.returnName() + ". You have " + user.returnTime() + " hours left in your day.");
    }
}