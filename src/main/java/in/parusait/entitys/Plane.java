package in.parusait.entitys;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="PLANE")
public class Plane {
	@Id
	@GeneratedValue
	@Column(name="PLANE_ID")
	private Integer planeId;
	
    @Column(name="PLANE_NAME")
	private String planeName;
    @Column(name="START_DATE")
    @CreationTimestamp
    private LocalDate startDate;
    @Column(name="END_DATE")
    @CreationTimestamp
    private LocalDate endDate;
    @Column(name="PLANE_CATEGORY_ID")
	private Integer planeCategoryId;
    
    @Column(name="ACTIVESW")
  	private String activeSw;
      @Column(name="CREATE_DATE")
      @CreationTimestamp
  	private LocalDate createDate;
      @Column(name="UPDATE_DATE")
      @CreationTimestamp
  	private LocalDate updateDate;
      @Column(name="CREATED_BY", updatable = false)
  	private String createdBy;
      @Column(name="UPDATED_BY", insertable =false)
  	private String updatedBy;
      
      
      


	

}
