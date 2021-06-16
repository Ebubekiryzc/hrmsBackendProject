package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SocialAccount;

public interface SocialAccountDao extends JpaRepository<SocialAccount, Integer>{

}
