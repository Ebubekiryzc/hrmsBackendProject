package kodlamaio.hrms.core.bussiness.abstracts;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface UserService {
	DataResult<User> getByEmail(String email);
}
