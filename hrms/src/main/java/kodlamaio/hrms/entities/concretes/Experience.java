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
@Table(name = "experiences")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume" })
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id",referencedColumnName = "id")
	@NotNull(message = "Which resume will be attended? Please select one.")
	private Resume resume;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name = "start_date")
	@NotBlank(message = "Please enter your start date.")
	private ZonedDateTime startDate;
	
	@Column(name = "end_date")
	private ZonedDateTime endDate;
	
}
