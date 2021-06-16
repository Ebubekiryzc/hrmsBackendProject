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
@Table(name = "schools")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "educationInfos", "faculties", "departments" })
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	@NotNull(message = "City must be selected.")
	private City city;

	@OneToMany(mappedBy = "school")
	private List<EducationInfo> educationInfos;

	@OneToMany(mappedBy = "school")
	private List<Faculty> faculties;

	@OneToMany(mappedBy = "school")
	private List<Department> departments;

	@Column(name = "school_name")
	@NotBlank(message = "Name field cannot be empty or null value.")
	private String schoolName;

}
