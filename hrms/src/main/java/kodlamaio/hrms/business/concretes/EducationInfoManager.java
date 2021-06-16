package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInfoDao;
import kodlamaio.hrms.entities.concretes.EducationInfo;

@Service
public class EducationInfoManager implements EducationInfoService {

	private EducationInfoDao educationInfoDao;
	
	@Autowired
	public EducationInfoManager(EducationInfoDao educationInfoDao) {
		super();
		this.educationInfoDao = educationInfoDao;
	}

	@Override
	public DataResult<List<EducationInfo>> getAll() {
		return new SuccessDataResult<List<EducationInfo>>(this.educationInfoDao.findAll(),"All education info records listed.");
	}
	

	@Override
	public DataResult<List<EducationInfo>> getByEndDateOrderByDesc() {
		return new SuccessDataResult<List<EducationInfo>>(this.educationInfoDao.getAllByOrderByEndDateDesc(),"All education info records listed regarding the end date.");
	}

	@Override
	public Result add(EducationInfo educationInfo) {
		this.educationInfoDao.save(educationInfo);
		return new SuccessResult("Education info added to resume.");
	}

	@Override
	public Result update(EducationInfo educationInfo) {
		if(this.educationInfoDao.findById(educationInfo.getId())==null) {
			return new ErrorResult("Education info not exist.");
		}
		this.educationInfoDao.save(educationInfo);
		return new SuccessResult("Education info updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.educationInfoDao.findById(id)==null) {
			return new ErrorResult("Education info not exist.");
		}
		this.educationInfoDao.deleteById(id);
		return new SuccessResult("Education info deleted.");
	}

}
