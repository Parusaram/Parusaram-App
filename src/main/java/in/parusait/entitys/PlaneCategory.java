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
@Table(name="PLANE_CATEGORY")
public class PlaneCategory {
	@Id
	@GeneratedValue
	@Column(name="PLANE_CATEGORY_ID")
	private Integer planecategoryId;
    @Column(name="CATEGORY_NAME")
	private String categoryName;
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
