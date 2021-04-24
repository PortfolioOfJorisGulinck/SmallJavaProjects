package be.kdg.judokas.persist;

import be.kdg.judokas.model.Geslacht;
import be.kdg.judokas.model.Judoka;
import be.kdg.judokas.model.Kampioenschap;
import be.kdg.judokas.model.Medaille;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joris Gulinck on 5/08/2017.
 */
public class JudokasDbDao implements JudokasDao {
    private Connection connection = null;
    private PreparedStatement insertStatement = null;
    private PreparedStatement deleteStatement = null;
    private PreparedStatement selectOneStatement = null;
    private PreparedStatement selectAllStatement = null;
    private PreparedStatement selectSomeStatement = null;
    private PreparedStatement updateStatement = null;

    public JudokasDbDao(String url) {
        try {
            connection = DriverManager.getConnection(url, "admin", "");
        } catch (SQLException e) {
            System.err.println("Unable to create connection");
            e.printStackTrace();
            System.exit(1);
        }

        maakTabel();

        try {
            insertStatement = connection.prepareStatement("INSERT INTO judokas (" +
                    "naam, geslacht, geboorte, gewicht, medaille, kampioenschap)" +
                    "VALUES(?,?,?,?,?,?)");
            selectOneStatement = connection.prepareStatement("SELECT * FROM judokas WHERE id = ?");
            deleteStatement = connection.prepareStatement("DELETE FROM judokas WHERE id = ?");
            selectSomeStatement = connection.prepareStatement("SELECT * FROM judokas WHERE gewicht > ?");
            updateStatement = connection.prepareStatement("UPDATE judokas " +
                    "SET naam = ?, geslacht = ?, geboorte = ?, gewicht = ?, medaille = ?, kampioenschap = ?" +
                    "WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void maakTabel() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS judokas");
            String createTable = "CREATE TABLE judokas " +
                    "(id INTEGER NOT NULL IDENTITY," +
                    "naam VARCHAR(30) NOT NULL," +
                    "geslacht VARCHAR(10) NOT NULL," +
                    "geboorte DATE NOT NULL," +
                    "gewicht NUMERIC (10) NOT NULL," +
                    "medaille VARCHAR(30) NOT NULL," +
                    "kampioenschap VARCHAR(30) NOT NULL)";
            statement.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean voegToe(Judoka judoka) {
        try {
            connection.setAutoCommit(false);
            completeStatement(insertStatement, judoka);
            insertStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void completeStatement(PreparedStatement statement, Judoka judoka) {
        try {
            statement.setString(1, judoka.getNaam());
            statement.setString(2, judoka.getGeslacht().name());
            statement.setDate(3, Date.valueOf(judoka.getGeboorte()));
            statement.setInt(4, judoka.getGewicht());
            statement.setString(5, judoka.getMedaille().name());
            statement.setString(6, judoka.getKampioenschap().name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Judoka zoek(int id) {
        ResultSet resultSet = null;
        Judoka teZoekenJudoka = null;
        try {
            selectOneStatement.setInt(1, id);
            resultSet = selectOneStatement.executeQuery();
            if (resultSet.next()) {
                teZoekenJudoka = zetDbOmInJudoka(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teZoekenJudoka;
    }

    public Judoka zetDbOmInJudoka(ResultSet resultSet) {
        Judoka judoka = null;
        try {
            judoka = new Judoka(
                    resultSet.getInt("id"),
                    resultSet.getString("naam"),
                    Geslacht.valueOf(resultSet.getString("geslacht")),
                    resultSet.getDate("geboorte").toLocalDate(),
                    resultSet.getInt("gewicht"),
                    Medaille.valueOf(resultSet.getString("medaille")),
                    Kampioenschap.valueOf(resultSet.getString("kampioenschap"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return judoka;
    }

    @Override
    public boolean verwijder(Judoka judoka) {
        try {
            deleteStatement.setInt(1, judoka.getId());
            deleteStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Judoka> gesorteerdOpNaam() {
        return sorteerDB("naam");
    }

    @Override
    public List<Judoka> gesorteerdOpGeboorte() {
        return sorteerDB("geboorte");
    }

    public List<Judoka> sorteerDB(String attribuut) {
        List<Judoka> lijst = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            selectAllStatement = connection.prepareStatement("SELECT * FROM judokas ORDER BY " + attribuut);
            resultSet = selectAllStatement.executeQuery();
            while (resultSet.next()) {
                Judoka judoka = zetDbOmInJudoka(resultSet);
                lijst.add(judoka);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lijst;
    }

    public List<Judoka> filterGewicht(int gewicht) {
        List<Judoka> lijst = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            selectSomeStatement.setInt(1, gewicht);
            resultSet = selectAllStatement.executeQuery();
            while (resultSet.next()) {
                Judoka judoka = zetDbOmInJudoka(resultSet);
                lijst.add(judoka);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lijst;
    }

    public boolean updateJudoka(Judoka judoka) {
        int geUpdateRijen = 0;
        completeStatement(updateStatement, judoka);
        try {
            updateStatement.setInt(7, judoka.getId());
            geUpdateRijen = updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return geUpdateRijen != 1;
    }
}
