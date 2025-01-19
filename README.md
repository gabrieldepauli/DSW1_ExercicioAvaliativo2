# Exercicio Avaliativo 2 🌐

## Descrição do Projeto

### Autor:

O projeto de Gerenciamento de Pedidos de uma empresa foi criado por Gabriel de Pauli Santos, aluno do curso de Análise e Desenvolvimento de Sistemas no IFSP - Campus Araraquara.


### Tecnologias utilizadas 👩‍💻

- **JSP:** Utilizado na criação das páginas usadas no projeto.
- **Java:** Principal linguagem de programação utilizada, necessária para a criação de toda a lógica das funções do programa.
- **Servlet:** Utilizado nos FrontControllers.
- **Command:** Utilizado para efetuar a execução da lógica de controle.
- **Session:** Utilizado para criar a sessão do usuário.
- **Filtros:** Utilizado para conferir a sessão do usuário para poder realizar o encaminhamento para as páginas.
- **SQL:** Utilizado para armazenar os dados no Banco de Dados.
- **Bootstrap:** Utilizado para estilizar as página JSP.
- **CSS:** Utilizado para fazer a estilização das páginas utilizadas.
- **Padrões de Projeto:** Foram utilizados os padrões FrontControler, Command, MVC, DAO, Factory (para DAO).
- **Aplicativos:** MySQL Workbench e Eclipse.

## Sobre o projeto ℹ

Este projeto é uma aplicação Web (desenvolvida no Eclipse) com linguagem JAVA que tem o objetivo de simular um sistema de gerenciamento de pedidos de uma empresa, onde se pode criar novos usuários para o sistema e também realizar a manutenção dos pedidos (criar Pedidos, alterar pedidos, deletar pedidos, consultar, pesquisar, etc...).

Para que o sistema funcione corretamente foram adicionadas algumas funções:

- **Página Index:** Esta página possui uma mensagem perguntando se deseja entrar no sistema e um botão para encaminhar para pagina de login.

- **Login:** Esta página possui um formulário de login com usuário (email) e senha, além de um botão para efetuar login, caso não seja completado os campos ou o usuário não coloque corretamente os dados do login, a página gera uma mensagem de erro.

- **Home:** Esta página possui todas as opções que o usuário terá acesso após realizar o seu Login, as opções são "Cadastrar novos usuários", "Cadastrar novos pedidos", "Visualizar pedidos" e Logout".

- **Logout:** Esta opção invalida a sessão do usuário e faz o logout do sistema, encaminhando para Index.

- **Cadastrar novos usuários:** Esta opção encaminha para um formulário onde será necessário inserir os dados (email e senha) do novo usuário do sistema que esta sendo cadastrado. Caso ocorra algum erro na inserção ele apresentará uma mensagem de erro, mas se for cadastrado com sucesso ele encaminhará para a página home do usuário apresentando uma mensagem de sucesso.

- **Cadastrar novos pedidos:** Esta opção encaminha para um formulário onde será necessário inserir os dados (nome do cliente, endereço do cliente, valor do pedido e descrição) do novo pedido que esta sendo cadastrado. Caso ocorra algum erro na inserção ele apresentará uma mensagem de erro, mas se for cadastrado com sucesso ele apresentará uma mensagem de sucesso na tela. **OBS:** O ID do pedido é gerado automaticamente pelo banco de dados.

- **Visualizar pedidos:** Esta opção encaminha para uma página onde será possível visualizar os dados (id, nome do cliente, endereço do cliente, valor do pedido e descrição) dos pedidos que foram cadastrados no banco de dados, além de um botão para excluir o pedido e outro para editar. Caso ocorra algum erro na exibição da página, como lista de pedidos vazia ele retorna para a página home do usuário e mostra uma mensagem na tela falando que a lista de pedidos está vazia.

- **Editar pedidos:** Esta opção encaminha para uma página onde será possível editar os dados (id, nome do cliente, endereço do cliente, valor do pedido e descrição) de um pedido em específico que foi cadastrados no banco de dados. Caso ocorra algum erro na edição do pedido, ele mostrará uma mensagem de erro na tela, mas se tiver sucesso ele encaminhará para a página de visualizar pedidos e mostrará uma mensagem de sucesso.

- **Excluir pedidos:** Esta opção apenas exclui o pedido selecionado da lista de pedidos e do banco de dados. Caso ocorra algum erro na hora de deletar o pedido, ele mostrará uma mensagem de erro, mas se tiver sucesso ele mostrará uma mensagem de sucesso.
