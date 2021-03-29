package Models;

import Connection.SqlServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Gado {

    private int Id;
    private String RFID;
    private Date dataNascimento;
    private Date dataAquisicao;
    private int IdRaca;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public int getIdRaca() {
        return IdRaca;
    }

    public void setIdRaca(int IdRaca) {
        this.IdRaca = IdRaca;
    }

    public void Inserir() {
        try {
            Connection con = new SqlServerConnection().getConnection();
            try (PreparedStatement novoGado = con.prepareStatement("INSERT INTO Gado (RFID_Gado,DtNascimento,IDRaca,DtAquisicao) VALUES (?, cast(? as date), ?, cast(? as date))")) {
                novoGado.setString(1, this.getRFID());
                java.sql.Date DataNascimentoSql = new java.sql.Date(this.getDataNascimento().getTime());
                novoGado.setDate(2, DataNascimentoSql);

                novoGado.setInt(3, this.getIdRaca());

                java.sql.Date DataAquisicaoSql = new java.sql.Date(this.getDataAquisicao().getTime());
                novoGado.setDate(4, DataAquisicaoSql);

                novoGado.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Gado cadastrado com sucesso");

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
        }
    }

    public void Alterar() {
        try {
            Connection con = new SqlServerConnection().getConnection();
            try (PreparedStatement alterarGado = con.prepareStatement("UPDATE Gado SET DtNascimento = ?, IDRaca = ?, DtAquisicao = ? WHERE RFID_Gado = ?")) {
                java.sql.Date DataNascimentoSql = new java.sql.Date(this.getDataNascimento().getTime());
                alterarGado.setDate(1, DataNascimentoSql);
                alterarGado.setInt(2, this.getIdRaca());
                java.sql.Date DataAquisicaoSql = new java.sql.Date(this.getDataAquisicao().getTime());
                alterarGado.setDate(3, DataAquisicaoSql);
                alterarGado.setString(4, this.getRFID());

                alterarGado.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
        }
    }

    public void Saida() {
        try {
            Connection con = new SqlServerConnection().getConnection();
            try (PreparedStatement excluirGado = con.prepareStatement("DELETE from Gado where RFID_Gado = ?")) {
                excluirGado.setString(1, this.getRFID());
                excluirGado.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Saída registrada com sucesso!");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
        }
    }

    public static List<String> CarregarCampos(String valor) throws SQLException {

        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement tabelaGado = con.prepareStatement("select RFID_Gado, convert(VARCHAR(10), DtNascimento, 103), IDRaca, convert(VARCHAR(10), DtAquisicao, 103) from Gado WHERE RFID_Gado LIKE ?");
            tabelaGado.setString(1, valor);

            ResultSet rs = tabelaGado.executeQuery();
            List<String> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getString(1));
                valores.add(rs.getString(2));
                valores.add(rs.getString(3));
                valores.add(rs.getString(4));
            }
            return valores;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    public static void CadastrarRaca(String descricao) {
        try {
            Connection con = new SqlServerConnection().getConnection();
            try (PreparedStatement novaRaca = con.prepareStatement("INSERT INTO Racas (Descricao) VALUES (?)")) {
                novaRaca.setString(1, descricao);
                novaRaca.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Raça cadastrada com sucesso!");

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static List<String> CarregarCombo() throws SQLException {
        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement tabelaRaca = con.prepareStatement("SELECT * FROM Racas");

            ResultSet rs = tabelaRaca.executeQuery();
            List<String> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getString(2));
            }
            return valores;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    public static boolean Validar(String rfid, String datanascimento, String dataaquisicao) {
        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement validarpk = con.prepareStatement("select count(*) from gado where RFID_Gado like ?");
            validarpk.setString(1, rfid);

            ResultSet rs = validarpk.executeQuery();
            List<String> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getString(1));
            }
            return valores.get(0).equals("0") && !rfid.trim().equals("") && !datanascimento.equals("  /  /    ") && !dataaquisicao.equals("  /  /    ");
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    public static PieDataset criarDadosFake() throws ClassNotFoundException, SQLException {

        Connection con = new SqlServerConnection().getConnection();
        PreparedStatement tabelaGadoRaca = con.prepareStatement("select Racas.Descricao, count(*) from Gado "
                + "inner join Racas on Gado.IDRaca=Racas.id_Raca "
                + "group by IDRaca, Racas.Descricao");

        ResultSet rs = tabelaGadoRaca.executeQuery();
        DefaultPieDataset dataSet = new DefaultPieDataset();

        while (rs.next()) {

            dataSet.setValue(rs.getString(1), Integer.parseInt(rs.getString(2)));
        }
        return dataSet;

    }

    public static DefaultTableModel CarregarTabela(String valor, DefaultTableModel tabela) {
        tabela.setRowCount(0);
        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement tabelaGeral = con.prepareStatement("select ID_GADO, RFID_GADO, Racas.Descricao, convert(VARCHAR(10), DtNascimento, 103), convert(VARCHAR(10), DtAquisicao, 103), null DtVenda from gado "
                    + "inner join Racas on gado.IDRaca=Racas.id_Raca "
                    + "where RFID_GADO like ? "
                    + "union all "
                    + "select ID_GADO, RFID_GADO, Racas.Descricao, convert(VARCHAR(10), DtNascimento, 103), convert(VARCHAR(10), DtAquisicao, 103), convert(VARCHAR(10), Data_Saida, 103) from Saida "
                    + "inner join Racas on Saida.IDRaca=Racas.id_Raca "
                    + "where RFID_GADO like ?");
            tabelaGeral.setString(1, valor);
            tabelaGeral.setString(2, valor);

            ResultSet rs = tabelaGeral.executeQuery();

            while (rs.next()) {

                tabela.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                }
                );

            }
            return tabela;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
        }
        return null;
    }

    public static DefaultTableModel CarregarTabelaPesagem(String valor, String verificar, DefaultTableModel tabela) {
        tabela.setRowCount(0);
        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement tabelaGeral = con.prepareStatement("SELECT TabelaApoio.ID_GADO "
                    + "	,TabelaApoio.RFID_GADO "
                    + "	,Peso "
                    + "	,convert(VARCHAR(10), DataAtual, 103) "
                    + "	,cast(datediff(day, dtNascimento, DataAtual) AS NVARCHAR) + ' dia(s)' "
                    + "	,isnull(cast(Peso - ( "
                    + "				SELECT TOP 1 Peso "
                    + "				FROM Pesagem "
                    + "				WHERE Pesagem.RFID_Gado = p.RFID_Gado "
                    + "					AND DataAtual < p.DataAtual "
                    + "					AND DataAtual BETWEEN DtNascimento "
                    + "						AND ISNull(DtVenda, getdate()) "
                    + "				ORDER BY DataAtual DESC "
                    + "				) AS NVARCHAR) + ' kg(s)', '-') "
                    + "	,CASE  "
                    + "		WHEN DtVenda IS NULL "
                    + "			THEN 0 "
                    + "		ELSE 1 "
                    + "		END Vendido "
                    + "FROM Pesagem p "
                    + "INNER JOIN ( "
                    + "	SELECT ID_GADO "
                    + "		,RFID_GADO "
                    + "		,Racas.Descricao "
                    + "		,DtNascimento "
                    + "		,DtAquisicao "
                    + "		,NULL DtVenda "
                    + "	FROM gado "
                    + "	INNER JOIN Racas ON gado.IDRaca = Racas.id_Raca "
                    + "	UNION "
                    + "	SELECT ID_GADO "
                    + "		,RFID_GADO "
                    + "		,Racas.Descricao "
                    + "		,DtNascimento "
                    + "		,DtAquisicao "
                    + "		,Data_Saida "
                    + "	FROM Saida "
                    + "	INNER JOIN Racas ON Saida.IDRaca = Racas.id_Raca "
                    + "	) TabelaApoio ON TabelaApoio.ID_GADO = ( "
                    + "		SELECT id_Gado "
                    + "		FROM ( "
                    + "			SELECT ID_GADO "
                    + "				,RFID_GADO "
                    + "				,Racas.Descricao "
                    + "				,DtNascimento "
                    + "				,DtAquisicao "
                    + "				,NULL DtVenda "
                    + "			FROM gado "
                    + "			INNER JOIN Racas ON gado.IDRaca = Racas.id_Raca "
                    + "			UNION "
                    + "			SELECT ID_GADO "
                    + "				,RFID_GADO "
                    + "				,Racas.Descricao "
                    + "				,DtNascimento "
                    + "				,DtAquisicao "
                    + "				,Data_Saida "
                    + "			FROM Saida "
                    + "			INNER JOIN Racas ON Saida.IDRaca = Racas.id_Raca "
                    + "			) t "
                    + "		WHERE p.RFID_Gado = t.RFID_GADO "
                    + "			AND p.DataAtual BETWEEN t.DtNascimento "
                    + "				AND ISNULL(DtVenda, getdate()) "
                    + "		)\n"
                    + "		WHERE TabelaApoio.RFID_GADO LIKE ? "
                    + "ORDER BY TabelaApoio.RFID_Gado "
                    + "	,p.DataAtual");
            tabelaGeral.setString(1, valor);

            ResultSet rs = tabelaGeral.executeQuery();

            while (rs.next()) {
                if (verificar.equals(rs.getString(7))) {
                    tabela.addRow(new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),}
                    );
                }
            }
            return tabela;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
