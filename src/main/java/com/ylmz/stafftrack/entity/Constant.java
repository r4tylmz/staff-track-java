package com.ylmz.stafftrack.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "constants")
public class Constant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String workingHourStart;
    private String workingHourEnd;
    private int WorkingHourPerWeek;
    private int WageByHour;
}
