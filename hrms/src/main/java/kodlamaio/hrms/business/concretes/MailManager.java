package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class MailManager implements MailService {

	@Override
	public Result sendVerificationMessage(User user, String verificationToken) {
		return new SuccessResult("Mail Sent: "+verificationToken);
	}

}
