package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "faculties")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "educationInfos", "departments" })
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "faculty")
	private List<EducationInfo> educationInfos;

	@ManyToOne()
	@JoinColumn(name = "school_id", referencedColumnName = "id")
	@NotNull(message = "School must be selected.")
	private School school;

	@OneToMany(mappedBy = "faculty")
	private List<Department> departments;

	@Column(name = "faculty_name")
	@NotBlank(message = "Name field cannot be empty or null value.")
	private String facultyName;

}
