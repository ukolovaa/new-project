import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PurchaseList")
@Getter
@Setter
public class PurchaseList {
    @EmbeddedId
    private PurchaseListKey id;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "student_name", referencedColumnName = "name", insertable = false, updatable = false)
//
//    @Column(name = "student_name", insertable = false, updatable = false)
//    private String studentName;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "course_name", referencedColumnName = "name", insertable = false, updatable = false)
//
//    @Column(name = "course_name", insertable = false, updatable = false)
//    private String courseName;
    private Integer price;
    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;
}