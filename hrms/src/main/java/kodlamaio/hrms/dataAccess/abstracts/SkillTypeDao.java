package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SkillType;

public interface SkillTypeDao extends JpaRepository<SkillType, Integer>{

}
