package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillTypeDao;
import kodlamaio.hrms.entities.concretes.SkillType;

@Service
public class SkillTypeManager implements SkillTypeService{

	private SkillTypeDao skillTypeDao;
	
	@Autowired
	public SkillTypeManager(SkillTypeDao skillTypeDao) {
		super();
		this.skillTypeDao = skillTypeDao;
	}

	@Override
	public DataResult<List<SkillType>> getAll() {
		return new SuccessDataResult<List<SkillType>>(this.skillTypeDao.findAll(),"All skill type records listed.");
	}

	@Override
	public Result add(SkillType skillType) {
		this.skillTypeDao.save(skillType);
		return new SuccessResult("Skill type added.");
	}

	@Override
	public Result update(SkillType skillType) {
		if(this.skillTypeDao.findById(skillType.getId())==null) {
			return new ErrorResult("Skill type not exist.");
		}
		this.skillTypeDao.save(skillType);
		return new SuccessResult("Skill type updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.skillTypeDao.findById(id)==null) {
			return new ErrorResult("Skill type not exist.");
		}
		this.skillTypeDao.deleteById(id);
		return new SuccessResult("Skill type deleted.");
	}

	
	
}
