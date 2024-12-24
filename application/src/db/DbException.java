package db;

import java.io.Serial;

public class DbException extends RuntimeException {

    @Serial // Indica que este campo é o serialVersionUID
    private static final long serialVersionUID = 1L; // Número de versão serial

    public DbException(String message) {
        super(message); // Chama o construtor da superclasse com a mensagem
    }
}

/**
 * serialVersionUID: Este campo é utilizado para identificar a versão de uma classe durante a serialização.
 Quando uma classe é serializada, o serialVersionUID é gravado junto com os dados. Se a classe for modificada (por exemplo,
 adicionando ou removendo campos), o serialVersionUID deve ser alterado para indicar que a versão da classe mudou.
 Isso ajuda a evitar problemas de compatibilidade ao tentar desserializar um objeto que foi salvo com uma versão diferente da classe.

 * Construtor: O construtor da classe chama o construtor da classe pai (RuntimeException) passando a mensagem de erro.
 Isso permite que a exceção carregue uma descrição do erro que pode ser útil para depuração.

 * RuntimeException: RuntimeException é uma exceção que pode ser lançada em tempo de execução.

 * A classe DbException é uma subclasse de RuntimeException, o que significa que é uma exceção não verificada.

 * Isso permite que os métodos que lançam essa exceção não precisem declará-la na lista de exceções.
 **/

/*
* A anotação @Serial é opcional, mas é uma boa prática usá-la para aumentar a clareza e a legibilidade do código.
* Para versões do Java anteriores ao 14, a anotação @Serial não está disponível, e o uso do serialVersionUID deve ser feito sem essa anotação.

* O Que é serialVersionUID?
O serialVersionUID é um campo estático e final que é utilizado pelo mecanismo de serialização do Java para verificar se
a versão de uma classe serializada é compatível com a versão da classe que está sendo deserializada. Quando um objeto é
serializado, o serialVersionUID é incluído no stream de bytes. Durante a deserialização, o Java verifica se o serialVersionUID
da classe que está sendo carregada corresponde ao serialVersionUID que foi gravado. Se não corresponder, pode ocorrer uma InvalidClassException.

* Por Que Usar a Anotação @Serial?
A anotação @Serial serve a dois propósitos principais:
    - Clareza: Ajuda a documentar que um campo específico é um serialVersionUID, tornando o código mais fácil de entender para outros desenvolvedores que possam trabalhar com ele.
    - Ferramentas de Análise de Código: Ferramentas de análise de código, como IDEs e linters, podem usar essa anotação para alertar os desenvolvedores sobre a necessidade de um serialVersionUID e para verificar se ele está corretamente implementado.
*/