package utils.props;

import java.sql.*;

public class TestDataReaderDb {

    private static Connection connection;


    public static void init() {
        if (connection == null) {
            try {
                connection = DriverManager
                        .getConnection("jdbc:mysql://localhost/w3schools?user=root&password=Rsjep@1993");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        ResultSet resultSet = preparedStatement.executeQuery();
    }

    public static ResultSet getData(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

}
