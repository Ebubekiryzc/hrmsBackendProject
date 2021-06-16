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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "educationInfos"})
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "department")
	private List<EducationInfo> educationInfos;
	
	@ManyToOne()
	@JoinColumn(name = "school_id", referencedColumnName = "id")
	@NotNull(message = "School must be selected.")
	private School school;
	
	@ManyToOne()
	@JoinColumn(name="faculty_id", referencedColumnName = "id")
	@NotNull(message = "Faculty must be selected.")
	private Faculty faculty;
	
	@Column(name="department_name")
	@NotNull(message = "Name field cannot be empty or null value.")
	private String departmentName;
}
