package com.ausy.employee.paylod;

import lombok.Data;
import java.util.Date;

@Data
public class EmployeeDto {
    private long id;
    private Date dateStart;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String majDC;
    private String statusOfChecking;
    private String managerMeeting;
    private String dcUpdated;
    private String dept;
    private String sponsor;
    private String talent;
    private String manager;
    private float exp;
    private String actions;
    private String competences;
    private String domain;
    private boolean seriousConstraint;
    private boolean mobilityFr;

    public boolean getMobilityFr() {
        return mobilityFr;
    }

    public boolean getSeriousConstraint() {
        return seriousConstraint;
    }
}
