import java.sql.*;

public class EventoDAO {

    private final Connection connection;

    public EventoDAO(Connection connection) {
        this.connection = connection;
    }

    public Integer salvar(Evento evento) {
        String sql = "insert into evento (id, nome, data) values (null, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, evento.getNome());
            preparedStatement.setDate(2, new Date(evento.getData().getTime()));

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();

                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
