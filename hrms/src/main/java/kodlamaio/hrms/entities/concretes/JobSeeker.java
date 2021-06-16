package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resumes"})
public class JobSeeker extends User {


	@Column(name = "first_name")
	@NotBlank(message = "First Name field cannot be empty or null value.")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Last Name field cannot be empty or null value.")
	private String lastName;

	@Column(name = "national_identity")
	@Size(min = 11, max = 11, message = "The National ID field must be consist of 11 characters.")
	@NotBlank(message = "National Id field cannot be empty or null value")
	private String nationalId;

	@Column(name = "year_of_birth")
	@NotNull(message = "Year of Birth field cannot be empty or null value.")
	private int yearOfBirth;
	

	@OneToMany(mappedBy = "jobSeeker")
	private List<Resume> resumes;
}
