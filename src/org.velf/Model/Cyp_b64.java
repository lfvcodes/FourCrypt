
package org.velf.Model;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class Cyp_b64{
    
    public Cyp_b64(){
       
    }
    
    public static String encrypt(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    
    public static String decrypt(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }
    
}
