import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Getter
@Setter
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
//
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
//
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;
}
