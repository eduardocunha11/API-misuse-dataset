/**
 * Source: https://github.com/360keke/peds/blob/master/pedsSpring/src/com/cn/v2/thirdCertificy/OAuthUtil.java
 */
public byte[] computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {
		SecretKey key = null;
		byte[] keyBytes = keyString.getBytes(ENCODE);
		key = new SecretKeySpec(keyBytes, "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(key);
		byte[] text = baseString.getBytes(ENCODE);
		return mac.doFinal(text);
}
