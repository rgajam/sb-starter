package com.smart.starter;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Test {

	public static void main(String[] args) {
		System.out.println("Result: " + getSecureRandom());
	}
	
	public static long getSecureRandom() {
		long result = -1;
		try {

			// Create a secure random number generator using the SHA1PRNG
			// algorithm
			SecureRandom secureRandomGenerator = SecureRandom
					.getInstance("SHA1PRNG");

			// Get 128 random bytes
			byte[] randomBytes = new byte[128];
			secureRandomGenerator.nextBytes(randomBytes);

			// Create two secure number generators with the same seed
			int seedByteCount = 5;
			byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);
			
			SecureRandom secureRandom1 = SecureRandom.getInstance("SHA1PRNG");
			secureRandom1.setSeed(seed);
			result = secureRandom1.nextLong();
			System.out.println("secureRandom Long: " + result);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}
