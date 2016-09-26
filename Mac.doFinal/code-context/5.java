/**
 * Source: https://github.com/cryptocyborg/Secure-Key-Exchanger-Java-/blob/master/src/SymIntTransmitter.java
 */
public byte[] EncryptMessage (byte[] msg,byte[] sharedKeyBytes,byte[] macKeyBytes) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, IllegalStateException
	 {
			IvParameterSpec ivSpec=  new IvParameterSpec(sharedKeyBytes);
		    Key key = new SecretKeySpec(sharedKeyBytes,"AES");
		    Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
		    String input = new String(msg);
		    Mac mac = Mac.getInstance("hmacsha1");
		    Key macKey = new SecretKeySpec(macKeyBytes, "DES");

		  
		    // actual encryption point
		    cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		    byte[] cipherText = new byte[cipher.getOutputSize(input.length() + mac.getMacLength())];
		    int ctLength = cipher.update(input.getBytes(), 0, input.length(), cipherText, 0);
		    mac.init(macKey);
		    mac.update(input.getBytes());
		    byte[] harshe = mac.doFinal();
		    ctLength += cipher.doFinal(harshe, 0, mac.getMacLength(), cipherText, ctLength);
		    System.out.println("cipherText : " + new String(cipherText));
			
			return cipherText; //Encrypted data is returned
}
