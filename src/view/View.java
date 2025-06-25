package view;

import model.GitHubEvent;

public class View {

    public void exibirEvento(GitHubEvent evento) {

        switch (evento.getType()) {
            case "PushEvent":
                System.out.println("Pushed " + evento.getPayload().getSize() + " commits to " + evento.getRepo().getName());
                break;
            case "CreateEvent":
                if (evento.getPayload().getRefType().equals("repository")) {
                    System.out.println("Started " + evento.getRepo().getName());
                }
                break;
            default:
                System.out.println("Event " + evento.getType() + " in " + evento.getRepo().getName());
        }
    }
}
