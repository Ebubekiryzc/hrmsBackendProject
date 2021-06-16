package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService{

	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(),"All department records listed.");
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("Department added.");
	}

	@Override
	public Result update(Department department) {
		if(this.departmentDao.findById(department.getId())==null) {
			return new ErrorResult("Department not exist.");
		}
		this.departmentDao.save(department);
		return new SuccessResult("Department updated.");
	}

	@Override
	public Result delete(int id) {
		if(this.departmentDao.findById(id)==null) {
			return new ErrorResult("Department not exist.");
		}
		this.departmentDao.deleteById(id);
		return new SuccessResult("Department deleted.");
	}	
}
