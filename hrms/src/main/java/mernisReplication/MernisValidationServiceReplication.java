package mernisReplication;

import java.util.Random;

public class MernisValidationServiceReplication { 

	public boolean userCheckService(String nationalId,int yearOfBirth) {
		Random random = new Random();
		return random.nextBoolean();
	}

}
