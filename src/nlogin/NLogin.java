/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nlogin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Mauro B H Jr
 */
public class NLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // TODO code application logic here
        String senha = "admin";

        MessageDigest mdMD5 = MessageDigest.getInstance("MD5");
        byte mdByteMD5[] = mdMD5.digest(senha.getBytes("UTF-8"));
        System.out.println("MD5: " + mdByteMD5);
        StringBuilder hexMDMD5 = new StringBuilder();
        for (byte b : mdByteMD5) {
            hexMDMD5.append(String.format("%02X", 0xFF & b));
        }
        String senhaMD5HashHex = hexMDMD5.toString();
        System.out.println(senhaMD5HashHex);

        MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
        byte mdByteSHA256[] = mdSHA256.digest(senha.getBytes("UTF-8"));
        System.out.println("SHA-256-Admin: " + mdByteSHA256);
        StringBuilder hexMdSHA256 = new StringBuilder();
        for (byte b : mdByteSHA256) {
            hexMdSHA256.append(String.format("%02X", 0xFF & b));
        }
        String senhaSHA256HashHex = hexMdSHA256.toString();
        System.out.println(senhaSHA256HashHex);

        //Cria senha para compara com o admin
        String senhaUser = "123456";
        byte mdByteSHA256User[] = mdSHA256.digest(senhaUser.getBytes("UTF-8"));
        System.out.println("SHA-256-User: " + mdByteSHA256User);
        StringBuilder hexMdSHA256User = new StringBuilder();
        for (byte b: mdByteSHA256User){
            hexMdSHA256User.append(String.format("%02X", 0xFF & b));
        }
        String senhaUser2 = hexMdSHA256User.toString();
        System.out.println(senhaUser2);
        //Compara senhas
        System.out.println(senhaUser2.equals(senhaSHA256HashHex));
        if (senhaUser2.equals(senhaSHA256HashHex)){
            System.out.println(".: Logado com sucesso :.");
        }else{
            System.out.println(".: Acesso negado :.\nUsuario ou senha invalido");
        }
    }
}
