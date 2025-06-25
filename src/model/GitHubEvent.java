package model;

public class GitHubEvent {

    private String type;
    GitHubPayload payload;
    GitHubRepo repo;

    public String getType() {
        return type;
    }

    public GitHubPayload getPayload() {
        return payload;
    }

    public GitHubRepo getRepo() {
        return repo;
    }
}
