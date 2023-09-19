
package org.velf.Controller;

import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import org.velf.Model.Messages;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.*;
import org.velf.Model.Cyp_aes128;
import org.velf.Model.Cyp_b64;
import org.velf.Model.Cyp_masked;
import org.velf.Model.Cyp_md5;

public class mainAppController implements Initializable {
    
    @FXML private AnchorPane anchorMain;
    @FXML private VBox stackMain;
    @FXML private Button btn_startEncrypt,btn_startDecrypt,btn_exit;
    @FXML private StackPane stk_main;
    @FXML private VBox stackOne;
    @FXML private Label lbl_inputString;
    @FXML private TextField txt_inputString;
    @FXML private Label lbl_cypherString;
    @FXML private TextArea txt_inputForCypher,txt_cypherString;
    @FXML private Button btn_cypherString;
    @FXML private VBox stackTwo;
    @FXML private Label lbl_inputDecypherString;
    @FXML private Label lbl_decypher;
    @FXML private TextArea txt_inputDecypher,txt_dectypher;
    @FXML private Button btn_decypher;
    @FXML private Label lbl_volver;
    
    byte[] cipherText;
    private String deText;
    private final String $pass = "K*L&ShN1k0vCrYpT";
    
    @FXML void cypher(ActionEvent event) throws UnsupportedEncodingException {
        
        if(this.txt_inputForCypher.getText().trim().length() >= 160 || (this.txt_inputForCypher.getText().trim().equals("")) ){
            Messages.showMsge("CHARACTER ERROR\\n\\n, THIS STRING IS INVALID, THE CHARACTER RANGE SHOULD BE: (1-160)");
            clearFields();
            return;
        }
        
        String ps = this.$pass;
        ps = Cyp_b64.encrypt(ps);
        for(int i=0; i<4; i++){
            ps = Cyp_md5.getMd5(ps);
        }
        
        this.cipherText = new byte[16];
        this.deText = Cyp_aes128.encriptar(ps, this.cipherText,this.txt_inputForCypher.getText().trim());
        deText = Cyp_masked.reverseCypher(deText.trim());
        this.txt_cypherString.setText(deText.trim());
        
        java.awt.datatransfer.Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(deText.trim());
        cb.setContents(ss, ss);
        
        Messages.showMsgi("The string has been encrypted Successfully\\nThe text has been copied to the clipboard.");
        
    }

    @FXML void decypher(ActionEvent event) throws UnsupportedEncodingException {
      
        if(this.txt_inputDecypher.getText().trim().length() >= 160 || (this.txt_inputDecypher.getText().trim().equals("")) ){
            Messages.showMsge("CHARACTER ERROR\\n\\n, THIS STRING IS INVALID, THE CHARACTER RANGE SHOULD BE: (1-160)");
            clearFields();
            return;
        }
        
        String ps = this.$pass;
        ps = Cyp_b64.encrypt(ps);
        for(int i=0; i<4; i++){
            ps = Cyp_md5.getMd5(ps);
        }
        
        cipherText = new byte[16];
        this.deText = this.txt_inputDecypher.getText().trim();
        this.deText = Cyp_masked.reverseDeCypher(deText.trim());
        this.deText = Cyp_aes128.decriptar(ps, cipherText,this.deText.trim());
        this.txt_dectypher.setText(this.deText.trim());
        
        java.awt.datatransfer.Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(deText.trim());
        cb.setContents(ss, ss);
        
        Messages.showMsgi("The string has been decrypted Successfully\\nThe text has been copied to the clipboard.");
        
        }
     
     void clearFields(){
         txt_inputDecypher.clear();
         txt_cypherString.clear();
         txt_inputForCypher.clear();
         txt_dectypher.clear();
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         this.lbl_volver.setVisible(false);
         this.stackMain.setVisible(true);
         this.stackOne.setVisible(false);
         this.stackTwo.setVisible(false);
         
        this.btn_startEncrypt.setOnAction((ActionEvent event) -> {
            this.stackMain.setVisible(false);
            this.stackTwo.setVisible(false);
            this.stackOne.setVisible(true);
            this.lbl_volver.setVisible(true);
        });
        
        this.btn_startDecrypt.setOnAction((ActionEvent event) -> {
            this.stackMain.setVisible(false);
            this.stackOne.setVisible(false);
            this.stackTwo.setVisible(true);
            this.lbl_volver.setVisible(true);
        });
        
        lbl_volver.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            
            clearFields(); 
            //return menu
            lbl_volver.setVisible(false);
            stackOne.setVisible(false);
            stackTwo.setVisible(false);
            stackMain.setVisible(true);
         });
        
        this.btn_exit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
    }    

    public byte[] stringToBytes(String s) {
	byte[] b2 = new BigInteger(s, 36).toByteArray();
	return Arrays.copyOfRange(b2, 1, b2.length);
    }
    
}
