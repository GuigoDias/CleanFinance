package org.example.MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection conectandoDB(){
        try {
            System.out.println("feito com sucesso");
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/comextrello?user=root&password=Bomber@4501");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
