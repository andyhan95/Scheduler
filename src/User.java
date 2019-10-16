public class User {
    public User(String nameInput, int timeInput, int tasksInput) {
        name = nameInput;
        time = timeInput; // time refers to how much free time they have available in hours
        tasks = tasksInput; // tasks refers to the number of tasks the user decides to have
    }

    public String returnName() { return name; }

    public int returnTime() {
        return time;
    }

    public int returnTasks() { return tasks; }

    public void createTasksArray(int tasks) {
        taskNames = new String[tasks];
        taskDurations = new int[tasks];
    }

    public void writeTaskName(String taskName, int i) {
        taskNames[i] = taskName;
    }

    public void writeTaskDuration(int taskDuration, int i) {
        taskDurations[i] = taskDuration;
    }

    public String callTaskName(int i) {
        return taskNames[i];
    }

    public int callTaskDuration(int i) {
        return taskDurations[i];
    }

    private String name;
    private int time;
    private int tasks;
    private String taskNames[];
    private int taskDurations[];
}