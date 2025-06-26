package view;

public class View {

    public void displayPushEvent(Integer size, String repoName) {
        System.out.println("Pushed " + size + " commits to " + repoName);
    }

    public void displayCreateEvent(String repoName) {
        System.out.println("Started " + repoName);
    }

    public void displayDefaultEvent(String eventType, String repoName) {
        System.out.println("Event " + eventType + " in " + repoName);
    }

    public void displayNotFoundExceptionError() {
        System.err.println("User not found! Try again.");
    }

    public void displayExceptionError() {
        System.err.println("Error found! Try again.");
    }

    public void displayUserError() {
        System.err.println("Invalid user!");
    }
}
