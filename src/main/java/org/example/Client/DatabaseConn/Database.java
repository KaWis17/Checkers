package org.example.Client.DatabaseConn;

import java.sql.*;

public class Database {
  Connection conn;

  public Database() throws ClassNotFoundException, SQLException {
    Class.forName("org.mariadb.jdbc.Driver");
    conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/warcaby",
            "root",
            "2104"
    );
  }

  public void addRecord(boolean isCurrentWhite, String text) throws SQLException {
    Statement stmt = conn.createStatement();
    if (isCurrentWhite)
      stmt.executeQuery("INSERT INTO board(isWhiteCurrent, board) VALUES (TRUE, '" + text + "')");
    else
      stmt.executeQuery("INSERT INTO board(isWhiteCurrent, board) VALUES (FALSE, '" + text + "')");
  }

  public boolean loadRecordBoolean() throws SQLException {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT isWhiteCurrent FROM board ORDER BY id DESC LIMIT 1");

    if(rs.next())
      return rs.getBoolean(1);
    return true;
  }

  public String loadRecordString() throws SQLException {
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT board FROM board ORDER BY id DESC LIMIT 1");

    if(rs.next())
      return rs.getString(1);
    return "[w0][b1][w0][b1][w0][b1][w0][b1]\n" +
            "[b1][w0][b1][w0][b1][w0][b1][w0]\n" +
            "[w0][b0][w0][b0][w0][b0][w0][b0]\n" +
            "[b0][w0][b0][w0][b0][w0][b0][w0]\n" +
            "[w0][b0][w0][b0][w0][b0][w0][b0]\n" +
            "[b0][w0][b0][w0][b0][w0][b0][w0]\n" +
            "[w0][b2][w0][b2][w0][b2][w0][b2]\n" +
            "[b2][w0][b2][w0][b2][w0][b2][w0]\n";
  }
}
