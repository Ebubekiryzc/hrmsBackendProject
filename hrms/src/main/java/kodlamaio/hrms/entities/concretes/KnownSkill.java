package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "known_skills")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume", "skill"})
public class KnownSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id",referencedColumnName = "id")
	@NotNull(message = "Which resume will be attended? Please select one.")
	private Resume resume;

	@ManyToOne()
	@JoinColumn(name = "skill_id",referencedColumnName = "id")
	@NotNull(message = "Which skill will be attended? Please select one.")
	private Skill skill;
	
}
