package work.atm.step2.domain.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementSetter {
    void setPreparedStatement(PreparedStatement preparedStatement) throws SQLException;
}
