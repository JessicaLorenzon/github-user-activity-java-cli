package model;

import java.util.List;

public class GitHubPayload {

    private Integer size;
    private String ref_type;
    List<GitHubCommit> gitHubCommits;

    public Integer getSize() {
        return size;
    }

    public List<GitHubCommit> getCommits() {
        return gitHubCommits;
    }

    public String getRefType() {
        return ref_type;
    }
}
