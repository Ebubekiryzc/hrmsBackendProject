package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "advertisements" })
public class Employer extends User {

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> advertisements;

	@Column(name = "company_name")
	@NotBlank(message = "Company Name field cannot be empty or null value.")
	private String companyName;

	@Column(name = "website")
	@NotBlank(message = "Web Site field cannot be empty or null value.")
	private String webSite;

	@Column(name = "phone")
	@NotBlank(message = "Phone field cannot be empty or null value.")
	private String phone;
}
