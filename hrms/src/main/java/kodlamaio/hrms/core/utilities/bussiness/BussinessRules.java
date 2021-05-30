package kodlamaio.hrms.core.utilities.bussiness;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BussinessRules {
	public static Result check(Result... rules) {
		for (Result rule : rules) {
			if (!rule.isSuccess()) {
				return rule;
			} 
		}
		return new SuccessResult();
	}
}
