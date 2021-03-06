package lampola.task1.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lampola.task1.enums.Sex;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter // Getters and setters are generated by Lombok
@Setter
public class Person extends AbstractPersistable<Long> {
	
	@NotBlank(message = "Social security number is mandatory")
    @Length(min = 11, max = 11)
	private String ssn;
	
	@NotBlank(message = "First name is mandatory")
    @Length(min = 1, max = 50)
	private String firstName;
	
    @Length(min = 1, max = 50)
	@NotBlank(message = "Last name is mandatory")
	private String lastName;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @PastOrPresent(message = "Date of birth must be in the past or today")
	@NotNull(message = "Last name is mandatory")
    private Date dateOfBirth;
    
    @Enumerated(EnumType.STRING)
	@NotNull(message = "Sex is mandatory")
    private Sex sex;
    
    @JsonIgnore
    @OneToMany
    private List<Marriage> husbands;
    
    @JsonIgnore
    @OneToMany
    private List<Marriage> wives;
}
