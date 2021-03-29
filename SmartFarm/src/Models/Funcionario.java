package Models;

import Connection.SqlServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Funcionario {

    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String adm;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public void Inserir() {
        try {
            Connection con = new SqlServerConnection().getConnection();
            try (PreparedStatement novoFuncionario = con.prepareStatement("INSERT INTO Usuarios (User_CPF, Password, Nome, Email, Adm) VALUES (?, ?, ?, ?, ?)")) {
                novoFuncionario.setString(1, this.getCpf());
                novoFuncionario.setString(2, this.getSenha());
                novoFuncionario.setString(3, this.getNome());
                novoFuncionario.setString(4, this.getEmail());
                novoFuncionario.setString(5, this.getAdm());

                novoFuncionario.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
        }
    }

    public void Alterar() {
        try {
            Connection con = new SqlServerConnection().getConnection();
            try (PreparedStatement alterarFuncionario = con.prepareStatement("UPDATE Usuarios SET Password = ?, Email = ?, Nome = ?, Adm = ? WHERE User_CPF = ?")) {
                alterarFuncionario.setString(1, this.getSenha());
                alterarFuncionario.setString(2, this.getEmail());
                alterarFuncionario.setString(3, this.getNome());
                alterarFuncionario.setString(4, this.getAdm());
                alterarFuncionario.setString(5, this.getCpf());

                alterarFuncionario.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
        }
    }

    public void Excluir() {
        try {
            Connection con = new SqlServerConnection().getConnection();
            try (PreparedStatement excluirFuncionario = con.prepareStatement("DELETE from Usuarios where User_CPF = ?")) {
                excluirFuncionario.setString(1, this.getCpf());

                excluirFuncionario.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
        }
    }

    public static List<String> CarregarCampos(String valor) throws SQLException {
        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement tabelaFuncionario = con.prepareStatement("SELECT * FROM Usuarios where User_CPF like ?");
            tabelaFuncionario.setString(1, valor);

            ResultSet rs = tabelaFuncionario.executeQuery();
            List<String> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getString(1));
                valores.add(rs.getString(2));
                valores.add(rs.getString(3));
                valores.add(rs.getString(4));
                valores.add(rs.getString(5));
            }
            return valores;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    public static List<String> ValidarAcesso(String cpf, String senha) throws SQLException {
        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement tabelaFuncionario = con.prepareStatement("SELECT * FROM Usuarios where User_CPF like ? and Password like ?");
            tabelaFuncionario.setString(1, cpf);
            tabelaFuncionario.setString(2, senha);

            ResultSet rs = tabelaFuncionario.executeQuery();
            List<String> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getString(5));
            }
            return valores;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    public static boolean Validar(String cpf, String nome, String password, String email) {
        try {
            Connection con = new SqlServerConnection().getConnection();
            PreparedStatement validarpk = con.prepareStatement("select count(*) from Usuarios where User_CPF like ?");
            validarpk.setString(1, cpf);

            ResultSet rs = validarpk.executeQuery();
            List<String> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getString(1));
            }

            return valores.get(0).equals("0") && !nome.trim().equals("") && !password.trim().equals("") && !email.trim().equals("") && nome.trim().contains(" ") && ValidarEmail(email);
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    public static boolean ValidarEmail(String email) {
        boolean valido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                valido = true;
            }
        }
        return valido;
    }
}
