package com.ylmz.stafftrack.entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Staffs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "staff_id")
    private List<StaffActivity> activities;
}
