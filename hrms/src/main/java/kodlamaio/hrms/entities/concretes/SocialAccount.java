package kodlamaio.hrms.entities.concretes;

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
@Table(name = "social_accounts")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume"})
public class SocialAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id",referencedColumnName = "id")
	@NotNull(message = "Which resume will be attended? Please select one.")
	private Resume resume;
	
	@Column(name = "account")
	@NotBlank(message ="Account field cannot be empty or null value.")
	private String accountUrl;
	
}
