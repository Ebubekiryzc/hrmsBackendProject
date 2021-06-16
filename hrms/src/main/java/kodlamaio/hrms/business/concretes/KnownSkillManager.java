package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.KnownSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.KnownSkillDao;
import kodlamaio.hrms.entities.concretes.KnownSkill;

@Service
public class KnownSkillManager implements KnownSkillService {

	private KnownSkillDao knownSkillDao;

	@Autowired
	public KnownSkillManager(KnownSkillDao knownSkillDao) {
		super();
		this.knownSkillDao = knownSkillDao;
	}

	@Override
	public DataResult<List<KnownSkill>> getAll() {
		return new SuccessDataResult<List<KnownSkill>>(this.knownSkillDao.findAll(), "All known skill records listed.");
	}

	@Override
	public Result add(KnownSkill knownSkill) {
		this.knownSkillDao.save(knownSkill);
		return new SuccessResult("Known skill added to resume.");
	}

	@Override
	public Result update(KnownSkill knownSkill) {
		if(this.knownSkillDao.findById(knownSkill.getId())==null) {
			return new ErrorResult("Known skill not exist.");
		}
		this.knownSkillDao.save(knownSkill);
		return new SuccessResult("Known skill updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.knownSkillDao.findById(id)==null) {
			return new ErrorResult("Known skill not exist.");
		}
		this.knownSkillDao.deleteById(id);
		return new SuccessResult("Known skill deleted.");
	}

}
