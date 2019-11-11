/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feisdet;

/**
 *
 * @author Akram
 */
public class feisdetgui extends javax.swing.JFrame {

    /**
     * Creates new form feisdetgui
     */
    
    //key generator
    int [] key_generat(String key){
        char keycha [ ] = key.toCharArray();
        int keyint = (int)keycha[0];
        int [] keys = new int [16];
        for (int i = 0; i < 16; i++) {
            keys[i]=keyint++;
            
        }
        return keys;
    }
    
    int [][] dive_blocks(String plain){
        char [] plch = plain.toCharArray();
        int c=0;
        int block_num = plch.length/2;
        char blocks[][]= new char [block_num][2];
        for (int i = 0; i < block_num; i++) {
            
             for (int j = 0; j < 2; j++) {
                blocks[i][j]= plch[j+c];
            }
             c+=2;
        }
        int blockint [][]= new int[blocks.length][2];
         for (int i = 0; i <blocks.length; i++) {
                    for (int j = 0; j < 2; j++) {
                        blockint[i][j]= (int) blocks[i][j];
                    }
        }
        return blockint;
                
    }
    
    String enc(int blocks[][],int [] keys){
        int [] r = new int[17];
        int [] l = new int[17];
        String ciphers= "";
        int cipher [][]= new int [blocks.length][2];
        for (int i = 0; i < blocks.length; i++) {
            r[0]= blocks[i][1];
             l[0]= blocks[i][0]; 
            
             for (int j = 0; j < 16; j++) {
              if (jComboBox1.getSelectedItem()=="AND")
                r[j+1]  = r[j] & keys[j];
              else
                   r[j+1]  = r[j] | keys[j];
              
                r[j+1]= r[j+1] ^ l[j];
                l[j+1]= r[j];
                
            }
             cipher [i][0]=r[16];
             cipher [i][1]=l[16];
                 System.out.println("lf "+l);
        }
        
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < cipher[i].length; j++) {
            
                ciphers +=(char) cipher[i][j];
            }
        }
        return ciphers;
    }
    String dec(int blocks[][],int [] keys){
         int [] r = new int[17];
        int [] l = new int[17];
        String plains= "";
        int plain [][]= new int [blocks.length][2];
        for (int i = 0; i < blocks.length; i++) {
            r[0]= blocks[i][1];
             l[0]= blocks[i][0];
             for (int j = 0; j< 0; j++) {
            if (jComboBox1.getSelectedItem()=="AND")
                 r[j+1]  = r[j] & keys[15-j];
              else
                r[j+1]  = r[j] | keys[15-j];
                r[j+1]= r[j+1] ^ l[j];
                l[j+1]= r[j];
                   
            }
            plain [i][0]=r[16];
             plain [i][1]=l[16];
        }
        for (int i = 0; i <plain.length; i++) {
            for (int j = 0; j < 2; j++) {
                plains +=(char) plain[i][j];
            }
        }
        return plains;
    }
   
    public feisdetgui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        plain_tf = new javax.swing.JTextField();
        key_tf = new javax.swing.JTextField();
        cipher_tf = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        enc_btn = new javax.swing.JButton();
        dec_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("plain txt");

        jLabel2.setText("key");

        jLabel3.setText("cipher txt");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AND", "OR" }));

        jLabel4.setText("function");

        enc_btn.setText("Encryption");
        enc_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enc_btnActionPerformed(evt);
            }
        });

        dec_btn.setText("Decryption");
        dec_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dec_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(plain_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(key_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cipher_tf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(enc_btn)
                .addGap(78, 78, 78)
                .addComponent(dec_btn)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plain_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(key_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cipher_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enc_btn)
                    .addComponent(dec_btn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enc_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enc_btnActionPerformed
        // TODO add your handling code here:
        String plain =plain_tf.getText();
        String key = key_tf.getText();
        int keys []= key_generat(key);
       int blocks[][] =dive_blocks( plain);
        String cipher = enc(blocks, keys);
       // System.out.println(cipher);
        cipher_tf.setText(cipher);
    }//GEN-LAST:event_enc_btnActionPerformed

    private void dec_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dec_btnActionPerformed
        // TODO add your handling code here:
        
         String plain =cipher_tf.getText();
        String key = key_tf.getText();
        int keys []= key_generat(key);
       int blocks[][] =dive_blocks( plain);
        String cipher = enc(blocks, keys);
        System.out.println(cipher);
       plain_tf.setText(cipher);
    }//GEN-LAST:event_dec_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(feisdetgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feisdetgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feisdetgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feisdetgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new feisdetgui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cipher_tf;
    private javax.swing.JButton dec_btn;
    private javax.swing.JButton enc_btn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField key_tf;
    private javax.swing.JTextField plain_tf;
    // End of variables declaration//GEN-END:variables
}
