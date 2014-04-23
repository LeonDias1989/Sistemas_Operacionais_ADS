package util;

import java.util.Random;

public class RandomUtil {

	Random r = new Random();

	public int geradorInt() {

		return r.nextInt(5) + 1;

	}

}
