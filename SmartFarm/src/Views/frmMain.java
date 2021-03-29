package Views;

import Connection.SqlServerConnection;

public class frmMain {

    public static void main(String[] args) {
        SqlServerConnection.testarConexao();
        new frmLogin().setVisible(true);
    }

}
