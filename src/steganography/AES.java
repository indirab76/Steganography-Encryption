package steganography;

import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
public class AES {

	private String str2 = "",strr="";
	
	public byte[] getHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		return digest.digest(password.getBytes("UTF-8"));
	}


	/**
	 * @param msgs
	 * @return
	 */
	public byte[] encryptMessage(String msgs,String key) {
		try{
			/*byte[] encodedkey = getHash(key);
                System.out.println("encodedKey: " +encodedkey[0]+ "encodedkey length:" +encodedkey.length);
			 */
			System.out.println(key);
			byte[] encodedkey = getHash(key);
			for(int i = 0; i < encodedkey.length; i++){
				System.out.print(encodedkey[i]);
			}
			System.out.println();

			//convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < encodedkey.length; i++) {
				sb.append(Integer.toString((encodedkey[i] & 0xff) + 0x100, 16).substring(1));
			}
			System.out.println("Hex format : " + sb.toString());


			SecretKeySpec k = new SecretKeySpec(encodedkey, "AES");
			Cipher c = Cipher.getInstance("AES");
			c.init(Cipher.ENCRYPT_MODE, k);
			byte[] dataToSend = msgs.getBytes();
			System.out.println("Length of message : "+dataToSend.length);
			byte[] encryptedData = c.doFinal(dataToSend);
			System.out.println("hello5");

			str2 = bytesToString(encryptedData);

			System.out.println("Message is:\n" + msgs + "\n"); 
			System.out.println("Encoded message is:\n" + str2 + "\n");


			return encryptedData;

		} 

		catch (Exception e) { 
			throw new RuntimeException("Encryption failed!", e); 
		} 

	}     	      


	public static String bytesToString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			sb.append((char) (bytes[i] + 128));
		}
		return sb.toString();
	}

	public static byte[] stringToBytes(String str) {
		int length = str.length();
		byte[] b = new byte[length];
		for (int i = 0; i < length; i++) {
			b[i] = (byte) (str.charAt(i) - 128);
		}
		return b;
	}

	// There are two decryption methods written below. In first method byte array is passed as
	// argument and in second method string is passed as argument. Now the point to be Noted is 
	// string passed in second method is generated from the conversion of byte array to string using
	// method written above namely "byteToString()". Similarly we have to convert this string to 
	// byteArray before using it for decryption in second method. Well this whole step is done only to
	// show the encrypted string, so the second method is only used if we want to do something with
	// the encrypted string or else first method is used... their no conversion is done.

	public String decryptMessage(byte[] encodedData, String key) throws BadPaddingException{ 
		try{ 


			byte[] encodedKey = getHash(key);
			System.out.println("Length of EncodedKey : "+encodedKey.length);
			System.out.println("Length of EncodedData : "+encodedData.length);

			SecretKeySpec k = new SecretKeySpec(encodedKey, "AES");
			Cipher c = Cipher.getInstance("AES");
			c.init(Cipher.DECRYPT_MODE, k);           
			byte[] originalData = c.doFinal(encodedData);

			strr = new String(originalData); 
			System.out.println(strr); 
			return strr; 
		} 

		catch (BadPaddingException e){
			Component veiw = null;
			JOptionPane.showMessageDialog(veiw,
					"Entered Password is incorrect. Please Try Again.", "Error!",
					JOptionPane.ERROR_MESSAGE);
			throw new BadPaddingException();
		}
		catch (Exception e) { 
			throw new RuntimeException("Decryption failed!", e); 
		} 
		
	} 


	public String decryptMessage(String str, String key1) {
		try{
			String key = key1;//... secret sequence of bytes

			byte[] encodedKey = getHash(key); 

			byte[] encryptedData = stringToBytes(str);

			//byte[] encodedData = msgs.getBytes();
			Cipher c = Cipher.getInstance("AES");
			SecretKeySpec k = new SecretKeySpec(encodedKey, "AES");
			c.init(Cipher.DECRYPT_MODE, k); 
			byte[] decryptedData = c.doFinal(encryptedData);

			System.out.println("Decrypted message:\n" + new String(decryptedData) + "\n");

			return str;
		}

		catch (Exception e) {
			throw new RuntimeException("Decryption failed!", e);
		}
	}
}