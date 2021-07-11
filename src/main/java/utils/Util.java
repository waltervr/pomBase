package utils;

import java.util.Random;

public class Util {

	public static String generateRandomName(String base){
		Random rand = new Random();
		return base+"-"+rand.nextInt(1000);
	}
}
