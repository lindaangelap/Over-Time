/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author hp
 */
public class LaporanLembur extends javax.swing.JInternalFrame {

    /**
     * Creates new form LaporanLembur
     */
    public LaporanLembur() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dim.width, dim.height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        btnCetak = new javax.swing.JButton();
        nip = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Laporan Lembur Pegawai");
        setPreferredSize(new java.awt.Dimension(153, 21));

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 257, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetak)
                    .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            String path = "view/LaporanDetail.jasper";
            String driver = "oracle.jdbc.OracleDriver";
            String konek = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "system";
            String password = "26september";
            HashMap parameter = new HashMap();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(konek, user, password);
            File reportFile = new File(path);
            InputStream jReport = this.getClass().getClassLoader().getResourceAsStream(reportFile.getPath());
            parameter.put("nip", Integer.parseInt(nip.getText()));
//                JasperReport jReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, conn);
//            JasperViewer.viewReport(jPrint, true);
//            JasperViewer.setDefaultLookAndFeelDecorated(true);
//        try {
//            String path = "view/LaporanLemburPegawai.jasper";
//            String driver = "oracle.jdbc.OracleDriver";
//            String konek = "jdbc:oracle:thin:@localhost:1521:XE";
//            String user = "system";
//            String password = "26september";
//            HashMap parameter = new HashMap();
//            Class.forName(driver);
//            Connection conn = DriverManager.getConnection(konek, user, password);
//            File reportFile = new File(path);
//            InputStream jReport = this.getClass().getClassLoader().getResourceAsStream(reportFile.getPath());
////                JasperReport jReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
////            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, conn);
////            JasperViewer.viewReport(jPrint, true);
////            JasperViewer.setDefaultLookAndFeelDecorated(true);
////            
//            
//            
//            
//            JasperPrint jp = JasperFillManager.fillReport(jReport, parameter,conn);
            JRViewer jViewer = new JRViewer(jPrint);
            jViewer.setOpaque(true);
            jViewer.setVisible(true);
            jScrollPane1.add(jViewer);
            jScrollPane1.setViewportView(jViewer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan Tidak Dapat Dicetak!\n" + e.getMessage(),
                    "Cetak Laporan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nip;
    // End of variables declaration//GEN-END:variables
}
