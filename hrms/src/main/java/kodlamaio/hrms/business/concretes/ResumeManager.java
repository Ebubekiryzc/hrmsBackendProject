package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;

	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), "All resume records listed.");
	}

	@Override
	public Result add(Resume resume) {
		this.checkAndSetFields(resume);
		this.resumeDao.save(resume);
		return new SuccessResult("Resume added.");
	}

	@Override
	public Result update(Resume resume) {
		if (this.resumeDao.findById(resume.getId()) == null) {
			return new ErrorResult("Resume not exist.");
		}
		this.checkAndSetFields(resume);
		this.resumeDao.save(resume);
		return new SuccessResult("Resume updated.");

	}

	@Override
	public Result delete(int id) {
		if (this.resumeDao.findById(id) == null) {
			return new ErrorResult("Resume not exist.");
		}
		this.resumeDao.deleteById(id);
		return new SuccessResult("Resume deleted.");
	}

	private void setEducationInfosIfExist(Resume resume) {
		if (resume.getEducationInfos().isEmpty()) {
			return;
		}
		for (var checker : resume.getEducationInfos()) {
			checker.setResume(resume);
		}
	}
	
	private void setExperiencesIfExist(Resume resume) {
		if (resume.getExperiences().isEmpty()) {
			return;
		}
		for (var checker : resume.getExperiences()) {
			checker.setResume(resume);
		}
	}
	
	private void checkAndSetFields(Resume resume) {
		this.setCoverLettersIfExist(resume);
		this.setEducationInfosIfExist(resume);
		this.setExperiencesIfExist(resume);
		this.setKnownLanguagesIfExist(resume);
		this.setKnownSkillsIfExist(resume);
		this.setPicturesIfExist(resume);
		this.setSocialAccountsIfExist(resume);
	}
	
	private void setKnownLanguagesIfExist(Resume resume) {
		if (resume.getKnownLanguages().isEmpty()) {
			return;
		}
		for (var checker : resume.getKnownLanguages()) {
			checker.setResume(resume);
		}			
	}
	
	private void setKnownSkillsIfExist(Resume resume) {
		if (resume.getKnownSkills().isEmpty()) {
			return;
		}
		for (var checker : resume.getKnownSkills()) {
			checker.setResume(resume);
		}
	}
	
	private void setSocialAccountsIfExist(Resume resume) {
		if (resume.getSocialAccounts().isEmpty()) {
			return;
		}
		for (var checker : resume.getSocialAccounts()) {
			checker.setResume(resume);
		}
	}
	
	private void setCoverLettersIfExist(Resume resume) {
		if (resume.getCoverLetters().isEmpty()) {
			return;
		}
		for (var checker : resume.getCoverLetters()) {
			checker.setResume(resume);
		}
	}

	private void setPicturesIfExist(Resume resume) {
		if (resume.getPictures().isEmpty()) {
			return;
		}
		for (var checker : resume.getPictures()) {
			checker.setResume(resume);
		}
	}

	
}
