package application;

import model.GitHubEvent;
import service.GitHubService;
import view.View;

public class Main {

    public static void main(String[] args) throws Exception {
        View view = new View();
        GitHubEvent[] gitHubEvents = GitHubService.buscaAtividade("JessicaLorenzon");

        for (GitHubEvent gitHubEvent : gitHubEvents) {
            view.exibirEvento(gitHubEvent);
        }
    }
}
