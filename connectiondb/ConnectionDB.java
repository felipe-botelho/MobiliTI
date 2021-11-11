package mobiliti.connectiondb;

import java.sql.*;

public class ConnectionDB {

    //responsável por estabelecer conexão com o DB
    public static Connection conector() {
        java.sql.Connection conexao = null;

        //chama o driver mysql
        String driver = "com.mysql.cj.jdbc.Driver";

        //armazena infos ref. a conexão com o DB
        String url = "jdbc:mysql://localhost:3307/mobiliti";
        String user = "root";
        String password = "Unigranrio@2021";

        //estabelece conexão com o DB
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem sucedida.");
            return conexao;
        } catch (Exception e) {
            System.out.println("Não foi possível se comunicar com o banco de dados.");
            System.out.println("MOTIVO: " + e);
            return null;
        }
    }
}
