/**
 * Fragment Source: https://github.com/0211hk/JT/blob/master/src/main/java/org/hk/jt/client/core/Request.java
 */

private String getSignature() throws NoSuchAlgorithmException,
			InvalidKeyException, UnsupportedEncodingException {
		String keyString = String.format(SIGN_FORMAT,
				config.getConsumerSercret(), config.getAccessTokenSercret());
		String signatureBaseString = getSignatureBaseString();
		Mac mac = Mac.getInstance(this.config.getAlgolithm());
		Key key = new SecretKeySpec(keyString.getBytes(),
				this.config.getAlgolithm());
		mac.init(key);
		byte[] digest = mac.doFinal(signatureBaseString.getBytes());
		return encodeURL(Base64.encodeBytes(digest));
}
