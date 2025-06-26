package controller;

import exception.NotFoundException;
import model.GitHubEvent;
import service.GitHubService;
import view.View;

public class Controller {
    View view = new View();

    public void run(String[] args) {
        if (args.length != 1) {
            view.displayUserError();
            return;
        }

        if (args[0].isBlank()) {
            view.displayUserError();
            return;
        }

        try {
            GitHubEvent[] gitHubEvents = GitHubService.searchActivity(args[0]);

            for (GitHubEvent gitHubEvent : gitHubEvents) {
                processEvent(gitHubEvent);
            }

        } catch (NotFoundException e) {
            view.displayNotFoundExceptionError();
        } catch (Exception e) {
            view.displayExceptionError();
        }
    }

    public void processEvent(GitHubEvent event) {
        switch (event.getType()) {
            case "PushEvent":
                view.displayPushEvent(event.getPayload().getSize(), event.getRepo().getName());
                break;
            case "CreateEvent":
                if (event.getPayload().getRefType().equals("repository")) {
                    view.displayCreateEvent(event.getRepo().getName());
                }
                break;
            default:
                view.displayDefaultEvent(event.getType(), event.getRepo().getName());
        }
    }
}
