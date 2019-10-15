public class User {
    public User(String nameInput, int timeInput) {
        name = nameInput;
        time = timeInput; // time refers to how much free time they have available in hours
    }

    public String returnName() {
        return name;
    }

    public int returnTime() {
        return time;
    }

    private String name;
    private int time;
}