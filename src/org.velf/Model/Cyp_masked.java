
/** CODE_BY_V3LF **/

package org.velf.Model;

public class Cyp_masked {
    
    public static String reverseCypher(String text){
        String rv[] = new String[4];
        rv[0] = text;
        
        if((rv[0].charAt(rv[0].length()-1)=='=') && ((rv[0].charAt(rv[0].length()-2)=='=')) ){
            text = text.substring(0, (text.length()-2));
            rv[1] = text.substring(0, (text.length()/2));
            rv[2] = text.substring(((text.length())/2),(text.length()));
            rv[3] = "*" + rv[2] + rv[1] + "==";
            return rv[3];
        }else{
            if((rv[0].charAt(rv[0].length()-1)=='=') && ((rv[0].charAt(rv[0].length()-2)!='=')) ){
                text = text.substring(0, (text.length()-1));
                rv[1] = text.substring(0, (text.length()/2));
                rv[2] = text.substring(((text.length())/2),text.length());
                rv[3] = rv[2] + rv[1];
                rv[3] = "*" + rv[2] + rv[1] + "=";
                return rv[3];
            }
            return null;
        }    
        
    }
    
    public static String reverseDeCypher(String text){
        //
        String rv[] = new String[4];
        rv[0] = text;
        
        if((rv[0].charAt(rv[0].length()-1)=='=') && ((rv[0].charAt(rv[0].length()-2)=='=')) ){
            text = text.substring(1, (text.length()-2));
            rv[1] = text.substring(0, (text.length()/2));
            rv[2] = text.substring(((text.length())/2),text.length());
            rv[3] = rv[2] + rv[1] + "==";
            return rv[3];
        }else{
            if((rv[0].charAt(rv[0].length()-1)=='=') && ((rv[0].charAt(rv[0].length()-2)!='=')) ){
                text = text.substring(1, (text.length()-1));
                if(text.length()%2!=0){
                    rv[1] = text.substring(0, ((text.length()+1)/2));
                    rv[2] = text.substring(((text.length()+1)/2),text.length());
                }
                else{ 
                    rv[1] = text.substring(0, (text.length()/2));
                    rv[2] = text.substring((text.length()/2),text.length());
                }
                rv[3] = rv[2] + rv[1] + "=";
                return rv[3];
            }    
            return null;
        }
    }
    
}
