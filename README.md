# Exemplo de Conexão com Banco de Dados JDBC

## Descrição
Este projeto demonstra como estabelecer uma conexão com um banco de dados MySQL usando JDBC (Java Database Connectivity)
em uma aplicação Java simples. O código é estruturado de forma a facilitar a compreensão e o uso do JDBC, incluindo tratamento
de erros e carregamento de configurações a partir de um arquivo de propriedades. O exemplo inclui a manipulação de transações
e a atualização de dados em uma tabela de vendedores.

## Estrutura do Projeto
```
src/
├── application/
│   └── Program.java                # Classe principal da aplicação
└── db/
    ├── DB.java                     # Classe responsável pela conexão com o banco de dados
    └── DbException.java            # Classe de exceção personalizada
database.sql                        # Script para criar o banco de dados e a tabela de departamentos
```

## Pré-requisitos

- Java Development Kit (JDK) 8 ou superior.
- MySQL Server instalado e em execução.
- Dependência do MySQL Connector/J no projeto (se estiver usando Maven, conforme indicado abaixo).

## Configuração

1. **Banco de Dados**: Certifique-se de que o servidor MySQL esteja em execução e que o banco de dados `coursejdbc` exista.
Você pode criar o banco de dados usando o seguinte comando SQL:

    ```sql
    CREATE DATABASE coursejdbc;
    ```

2. **Tabela de Vendedores e Departamentos**: Execute o script `database.sql`, que se encontra na raiz do seu diretório do projeto.
Este script cria as tabelas `seller` e `department` necessárias para o funcionamento do exemplo.

3. **Arquivo de Propriedades**: Crie um arquivo chamado `db.properties` na raiz do seu diretório do projeto com o seguinte conteúdo:

    ```properties
    user=root
    password=123456
    dburl=jdbc:mysql://localhost:3306/coursejdbc
    useSSL=false
    ```

   **Obs.**: Substitua os valores de `user` e `password` pelas credenciais do seu banco de dados, se necessário.

4. **Dependências**: Se você estiver usando Maven, adicione a seguinte dependência ao seu arquivo `pom.xml`:

    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.23</version> <!-- Verifique se há uma versão mais recente -->
    </dependency>
    ```

## Como Executar

1. Compile o projeto. Se estiver usando um IDE como IntelliJ IDEA ou Eclipse, você pode usar o recurso de compilação integrado.

2. Execute a classe `Program.java`:

    ```bash
    java application.Program
    ```

3. O programa tentará estabelecer uma conexão com o banco de dados, atualizar os dados na tabela `seller` e exibirá o número
de linhas afetadas pela operação. Se houver um erro, a transação será revertida.

## Estrutura do Código

- **DbException.java**: Classe de exceção personalizada que estende `RuntimeException` para lidar com erros relacionados ao banco de dados.
- **DB.java**: Classe que contém métodos para obter e fechar a conexão com o banco de dados. Ela carrega as propriedades
de configuração a partir do arquivo `db.properties`.
- **Program.java**: Classe principal que contém o método `main`, onde a conexão com o banco de dados é estabelecida e os dados são atualizados.

## Instruções de Erro

Durante a execução do projeto, você pode encontrar alguns erros comuns. Abaixo estão algumas soluções para problemas frequentemente relatados:

1. **Erro de conexão com o banco de dados**:
    - **Mensagem de erro**: `Communications link failure`
    - **Solução**: Verifique se o servidor MySQL está em execução. Certifique-se de que as credenciais (usuário e senha)
   e a URL do banco de dados no arquivo `db.properties` estão corretas.

2. **Banco de dados não encontrado**:
    - **Mensagem de erro**: `Unknown database 'coursejdbc'`
    - **Solução**: Verifique se o banco de dados `coursejdbc` foi criado. Use o comando SQL fornecido na seção de configuração para criá-lo.

3. **Tabela não encontrada**:
    - **Mensagem de erro**: `Table 'coursejdbc.seller' doesn't exist`
    - **Solução**: Certifique-se de que o script `database.sql` foi executado corretamente e que a tabela `seller` foi criada.

4. **Problemas de dependência**:
    - **Mensagem de erro**: `ClassNotFoundException: com.mysql.cj.jdbc.Driver`
    - **Solução**: Certifique-se de que a dependência do MySQL Connector/J está corretamente adicionada ao seu arquivo 
   `pom.xml` (se estiver usando Maven) e que o projeto foi compilado corretamente.

5. **Erro de configuração SSL**:
    - **Mensagem de erro**: `SSL connection error`
    - **Solução**: Se você não deseja usar SSL, verifique se o parâmetro `useSSL` no arquivo `db.properties` está definido
   como `false`. Se precisar usar SSL, certifique-se de que o MySQL está configurado para suportá-lo.

6. **Outros erros**:
    - **Solução**: Consulte a documentação do JDBC ou do MySQL para obter mais informações sobre a mensagem de erro específica
   que você está enfrentando. Você também pode verificar os logs do MySQL para mais detalhes.

Caso você enfrente um erro que não está listado aqui, sinta-se à vontade para buscar ajuda em fóruns online ou consultar a documentação oficial do JDBC e do MySQL.

## Considerações Finais

Este exemplo fornece uma estrutura básica para conectar-se a um banco de dados MySQL usando JDBC em Java. Ele demonstra 
como manipular transações e atualizar dados em uma tabela, podendo ser expandido para incluir operações de banco de dados
mais complexas, como inserções e exclusões.

Se você deseja aprender mais sobre o JDBC, consulte a [documentação oficial](https://docs.oracle.com/javase/tutorial/jdbc/index.html)

---