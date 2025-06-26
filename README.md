# GitHub User Activity

Projeto feito seguindo o roadmap de projetos do [roadmap.sh](https://roadmap.sh/projects/github-user-activity), com o
objetivo de praticar Java e consumir APIs REST.

## Descrição

O GitHub User Activity é uma aplicação de linha de comando (CLI) que exibe as atividades públicas recentes de um usuário
do GitHub.  
Com ela, é possível visualizar eventos recentes, como commits, criação de repositorios etc, utilizando a GitHub REST
API.

## Tecnologias utilizadas

- **Java** - Linguagem principal
- [**Gson**](https://github.com/google/gson) - Biblioteca para serialização e desserialização de objetos JSON
- [**GitHub REST API**](https://docs.github.com/en/rest/activity/events?apiVersion=2022-11-28) - API pública para obter
  dados dos usuários
- **CLI (Command Line Interface)** - Interface baseada em terminal
- **Arquivo `.jar`** - Distribuição da aplicação empacotada

## Como rodar o projeto

### 1. Baixe ou clone o repositório

```bash
git clone https://github.com/JessicaLorenzon/github-user-activity-java-cli
cd github-user-activity-java-cli
```

### 2. Navegue até o diretório onde está o `.jar`:

```bash
cd out/artifacts/github_user_activity_java_jar
```

### 3. Execute o aplicativo:

```bash
java -jar github-user-activity-java.jar
```

## Exemplo de uso:

```bash
$ java -jar github-user-activity-java.jar "nomeDeUsuario"

# Saida:
- Pushed 3 commits to nomeDeUsuario/repositorio
- Started nomeDeUsuario/repositorio
- Event tipoDoEvento repositorio
```