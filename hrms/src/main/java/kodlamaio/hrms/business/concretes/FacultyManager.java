package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FacultyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FacultyDao;
import kodlamaio.hrms.entities.concretes.Faculty;

@Service
public class FacultyManager implements FacultyService{

	private FacultyDao facultyDao;

	@Autowired
	public FacultyManager(FacultyDao facultyDao) {
		super();
		this.facultyDao = facultyDao;
	}

	@Override
	public DataResult<List<Faculty>> getAll() {
		return new SuccessDataResult<List<Faculty>>(this.facultyDao.findAll(),"All faculty records listed.");
	}

	@Override
	public Result add(Faculty faculty) {
		this.facultyDao.save(faculty);
		return new SuccessResult("Faculty added.");
	}

	@Override
	public Result update(Faculty faculty) {
		if(this.facultyDao.findById(faculty.getId())==null) {
			return new ErrorResult("Faculty not exist.");
		}
		this.facultyDao.save(faculty);
		return new SuccessResult("Faculty updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.facultyDao.findById(id)==null) {
			return new ErrorResult("Faculty not exist.");
		}
		this.facultyDao.deleteById(id);
		return new SuccessResult("Faculty deleted.");
	}
	
}
