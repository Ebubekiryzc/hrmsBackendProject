package kodlamaio.hrms.entities.concretes;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: Formula annotation'u kullanarak eğer günümüz tarihi son tarihten sonra ise pasiflik durumunu güncellemesini sağla.

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "job_id", referencedColumnName = "id")
	private Job job;

	@ManyToOne()
	@JoinColumn(name = "employer_id", referencedColumnName = "user_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@OneToOne(mappedBy = "advertisement", cascade = CascadeType.ALL)
	private Salary salary;

	@Column(name = "description")
	private String description;

	@Column(name = "quota")
	@Positive
	private int quota;

	@Column(name = "creation_date")
	private ZonedDateTime creationDate;

	@Column(name = "advertisement_deadline")
	private ZonedDateTime advertisementDeadline;

	@Column(name = "is_active")
	private boolean isActive;
}