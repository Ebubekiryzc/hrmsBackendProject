package kodlamaio.hrms.entities.concretes;

import java.time.ZonedDateTime;

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
@Table(name = "education_infos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume"})
public class EducationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id",referencedColumnName = "id")
	@NotNull(message = "Which resume will be attended? Please select one.")
	private Resume resume;

	@ManyToOne()
	@JoinColumn(name="school_id",referencedColumnName = "id")
	@NotNull(message = "Which school will be attended? Please select one.")
	private School school;
	
	@ManyToOne()
	@JoinColumn(name="faculty_id",referencedColumnName = "id")
	@NotNull(message = "Which faculty will be attended? Please select one.")
	private Faculty faculty;
	
	@ManyToOne()
	@JoinColumn(name="department_id",referencedColumnName = "id")
	@NotNull(message = "Which department will be attended? Please select one.")
	private Department department;
	
	@Column(name = "start_date")
	@NotNull(message = "Please enter your start date.")
	private ZonedDateTime startDate;
	
	@Column(name = "end_date")
	private ZonedDateTime endDate;
}
