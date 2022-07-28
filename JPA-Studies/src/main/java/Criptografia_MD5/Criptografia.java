package Criptografia_MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Criptografia {
 private static MessageDigest md = null;
 static {
 try {
//Cria o objeto com a instancia de criptografia no padrão MD5
 md = MessageDigest.getInstance("MD5");
 } catch (NoSuchAlgorithmException ex) {
 ex.printStackTrace();
 }
 }
//Método para criar a chave criptografada
private static char[] hexCodes(byte[] text) {
char[] hexOutput = new char[text.length * 2];
String hexString;
for (int i = 0; i < text.length; i++) {
hexString = "00" + Integer.toHexString(text[i]);
hexString.toUpperCase().getChars(hexString.length()
- 2, hexString.length(), hexOutput, i * 2);
}
return hexOutput;
}
//Método para criptografar o texto
public static String criptografar(String pwd) {
if (md != null) {
return new
String(hexCodes(md.digest(pwd.getBytes())));
}
return null;
}
}