package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

    public static void main(String[] args) {

        Connection conn = null; // Inicializa a conexão como nula
        Statement st = null; // Inicializa o Statement como nulo

        try {
            // Obtém a conexão com o banco de dados
            conn = DB.getConnection();

            // Inicia a transação
            conn.setAutoCommit(false); // Desativa o auto-commit para permitir transações

            // Prepara a instrução SQL para atualizar o salário base dos vendedores
            st = conn.createStatement();

            // Executa a atualização do salário para vendedores do departamento 1
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            // Comentado: Simulação de erro para teste
            /*
            int x = 1;
            if (x < 2) {
                throw new SQLException("Fake error"); // Lança uma exceção SQL simulada
            }
            */

            // Executa a atualização do salário para vendedores do departamento 2
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            // Confirma a transação se tudo ocorrer sem erros
            conn.commit(); // Realiza o commit das alterações

            // Exibe o número de linhas afetadas
            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);
        } catch (SQLException e) {
            try {
                conn.rollback(); // Reverte as alterações em caso de erro
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage()); // Lança uma exceção personalizada
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage()); // Lança exceção se falhar ao reverter
            }
        } finally {
            DB.closeStatement(st); // Fecha o Statement
            DB.closeConnection(); // Fecha a conexão
        }
    }
}