package com.ausy.employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "employee"
)
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "dateStart", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date dateStart;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "majDC")
    private String majDC;

    @Column(name = "statusOfChecking")
    private String statusOfChecking;

    @Column(name = "managerMeeting")
    private String managerMeeting;

    @Column(name = "dcUpdated")
    private String dcUpdated;

    @Column(name = "dept")
    private String dept;

    @Column(name = "sponsor")
    private String sponsor;

    @Column(name = "talent")
    private String talent;

    @Column(name = "manager")
    private String manager;

    @Column(name = "exp", nullable = false)
    private float exp;

    @Column(name = "actions")
    private String actions;

    @Column(name = "competences")
    private String competences;

    @Column(name = "domain")
    private String domain;

    @Column(name = "seriousConstraint")
    private boolean seriousConstraint;

    @Column(name = "mobilityFr")
    private boolean mobilityFr;

}
