package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salaries")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "advertisement" })
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne()
	@JoinColumn(name = "job_advertisement_id", referencedColumnName = "id")
	@NotNull(message = "Which advertisement will be attended? Please select one.")
	private JobAdvertisement advertisement;

	@Column(name = "min_salary")
	@PositiveOrZero
	private double minSalary;

	@Column(name = "max_salary")
	@PositiveOrZero
	private double maxSalary;
}
