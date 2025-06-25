package service;

import com.google.gson.Gson;
import model.GitHubEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubService {

    static String webService = "https://api.github.com/users/";
    static int codigoSucesso = 200;

    public static GitHubEvent[] buscaAtividade(String usuario) throws Exception {
        String urlParaChamada = webService + usuario + "/events";

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso) {
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }

            try (BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
                String jsonEmString = converteRespostaEmString(resposta);

                Gson gson = new Gson();

                return gson.fromJson(jsonEmString, GitHubEvent[].class);
            }

        } catch (Exception e) {
            throw new Exception("Erro ao buscar atividade: " + e.getMessage(), e);
        }
    }

    public static String converteRespostaEmString(BufferedReader buffereReader) throws IOException {
        StringBuilder jsonEmString = new StringBuilder();

        String resposta;

        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString.append(resposta);
        }
        return jsonEmString.toString();
    }
}
