package Views;

import Models.Gado;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class frmGado extends javax.swing.JFrame implements ListSelectionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frmGado frame = new frmGado();
                    frame.setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }
    
    public frmGado() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.setLocationRelativeTo(null);

        btnAlterar.setEnabled(false);
        btnSaida.setEnabled(false);

        DefaultComboBoxModel defaultComboModel = new DefaultComboBoxModel(Gado.CarregarCombo().toArray());
        cbRaca.setModel(defaultComboModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lbRaca = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        btnAlterar = new javax.swing.JButton();
        lbDataNascimento = new javax.swing.JLabel();
        lbDataAquisicao = new javax.swing.JLabel();
        lbRFID = new javax.swing.JLabel();
        txtRFID = new javax.swing.JTextField();
        cbRaca = new javax.swing.JComboBox<>();
        btnSaida = new javax.swing.JButton();
        lbGado = new javax.swing.JLabel();
        btnRaca = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        txtDataAquisicao = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 450));
        setResizable(false);

        jLabel1.setText("jLabel1");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lbRaca.setText("Raça");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        lbDataNascimento.setText("Data de Nascimento");

        lbDataAquisicao.setText("Data da Aquisição");

        lbRFID.setText("Código do RFID");

        txtRFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFIDActionPerformed(evt);
            }
        });

        cbRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Angus", "Caracu" }));

        btnSaida.setText("Registrar Saída");
        btnSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaidaActionPerformed(evt);
            }
        });

        lbGado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbGado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Gado.png"))); // NOI18N
        lbGado.setMaximumSize(new java.awt.Dimension(100, 14));

        btnRaca.setText("+");
        btnRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRacaActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar por RFID");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        try {
            txtDataAquisicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbGado, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDataNascimento)
                            .addComponent(lbDataAquisicao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbRFID)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRFID, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbRaca)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnRaca))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(btnLimpar)
                            .addGap(50, 50, 50)
                            .addComponent(btnCadastrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRFID)
                    .addComponent(lbRaca)
                    .addComponent(cbRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataNascimento)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataAquisicao)
                    .addComponent(txtDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar)
                    .addComponent(btnLimpar)
                    .addComponent(btnSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            if (!txtDataNascimento.getText().equals("  /  /    ") && !txtDataAquisicao.getText().equals("  /  /    ")) {
                Gado g = new Gado();

                g.setRFID(txtRFID.getText());
                g.setIdRaca(cbRaca.getSelectedIndex());

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                g.setDataNascimento(formato.parse(txtDataNascimento.getText()));
                g.setDataAquisicao(formato.parse(txtDataAquisicao.getText()));

                g.Alterar();
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
            }
            Limpar();
        } catch (ParseException ex) {
            Logger.getLogger(frmGado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtRFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFIDActionPerformed

    private void btnSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaidaActionPerformed
        Gado g = new Gado();
        g.setRFID(txtRFID.getText());
        g.Saida();
        Limpar();
    }//GEN-LAST:event_btnSaidaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            if (Gado.Validar(txtRFID.getText(), txtDataNascimento.getText(), txtDataAquisicao.getText())) {
                Gado g = new Gado();

                g.setRFID(txtRFID.getText());
                g.setIdRaca(cbRaca.getSelectedIndex());

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                g.setDataNascimento(formato.parse(txtDataNascimento.getText()));
                g.setDataAquisicao(formato.parse(txtDataAquisicao.getText()));

                g.Inserir();
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos ou em branco");
            }
            Limpar();

        } catch (ParseException ex) {
            Logger.getLogger(frmGado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new frmMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRacaActionPerformed
        new frmRaca().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRacaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        new frmLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            String valor = txtPesquisar.getText();

            List<String> valores = new ArrayList<>();
            valores = Gado.CarregarCampos(valor);
            if (valores.size() > 0) {
                btnAlterar.setEnabled(true);
                btnSaida.setEnabled(true);
                btnCadastrar.setEnabled(false);
                txtRFID.setText(valores.get(0));
                txtRFID.setEnabled(false);
                txtDataNascimento.setText(valores.get(1));
                txtDataAquisicao.setText(valores.get(3));
                cbRaca.setSelectedIndex(Integer.parseInt(valores.get(2)));               
            } else {
                Limpar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmGado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void Limpar() {
        txtPesquisar.setText("");
        txtRFID.setText("");
        txtRFID.setEnabled(true);

        txtDataNascimento.setText("");
        txtDataAquisicao.setText("");
        cbRaca.setSelectedIndex(0);

        btnCadastrar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnSaida.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRaca;
    private javax.swing.JButton btnSaida;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbRaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbDataAquisicao;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbGado;
    private javax.swing.JLabel lbRFID;
    private javax.swing.JLabel lbRaca;
    private javax.swing.JFormattedTextField txtDataAquisicao;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtRFID;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
