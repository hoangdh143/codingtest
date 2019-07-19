package com.mitrais.codingtest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mitrais.codingtest.utils.constraint.PhoneValidationConstraint;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Phone number must not be null")
    @NotEmpty(message = "Phone number must not be empty")
    @PhoneValidationConstraint
    private String phone;

    @NotNull(message = "First Name must not be null")
    @NotEmpty(message = "First Name must not be empty")
    private String firstName;

    @NotNull(message = "Last Name must not be null")
    @NotEmpty(message = "Last Name must not be empty")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    private Boolean gender;

    @Column(unique = true)
    @NotNull(message = "Email must not be null")
    @NotEmpty(message = "Email must not be empty")
    private String email;
}
