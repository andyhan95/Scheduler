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
        System.out.println("How many tasks do you intend to complete today?");
        Scanner tasksScanner = new Scanner(System.in);
        int tasks = tasksScanner.nextInt();

        User user = createProfile(name, time, tasks);

        System.out.println("Welcome " + user.returnName() + ". You have " + user.returnTime() + " hours left in your day.");
        System.out.println("You have " + user.returnTasks() + " tasks to do.");

        addTasks(tasks, user);

        int totalTime = calculateTotalTime(tasks, user);

        presentResults(time, user, totalTime);
    }

    private static void presentResults(int time, User user, int totalTime) {
        if(totalTime > time) {
            System.out.println(user.returnName() + ", you don't have enough time to finish all of your tasks.");
            System.out.println("You have " + time + " hours of free time but your tasks add up to " + totalTime + ".");
            System.out.println("Ending program.");
        }
        else {
            System.out.println(user.returnName() + ", it looks like you can fit all of your tasks into today. Great!");
            System.out.println("You have " + time + " hours of free time and your tasks add up to " + totalTime + ".");
            if(time == totalTime) {
                System.out.println("It looks like you'll have a packed day though!\nEnding program.");
            }
            else {
                System.out.println("Even after you finish all of your tasks, you still have " + (time - totalTime) + " hours left to relax.\nEnding program.");
            }
        }
    }

    private static int calculateTotalTime(int tasks, User user) {
        int totalTime = 0;

        for(int i = 0; i < tasks; i++) {
            totalTime += user.callTaskDuration(i);
        }
        return totalTime;
    }

    private static void addTasks(int tasks, User user) {
        for(int i = 0; i < tasks; i++) {
            System.out.println("What is the name of task number " + (i + 1) + "?");
            Scanner taskNameScanner = new Scanner(System.in);
            user.writeTaskName(taskNameScanner.nextLine(), i);
            System.out.println("How many hour(s) will " + user.callTaskName(i) + " take?");
            Scanner taskDurationScanner = new Scanner(System.in);
            user.writeTaskDuration(taskDurationScanner.nextInt(), i);
        }
    }

    private static User createProfile(String name, int time, int tasks) {
        System.out.println("Initializing profile...");
        User user = new User(name, time, tasks);
        user.createTasksArray(tasks);
        System.out.println("Done.");
        return user;
    }
}