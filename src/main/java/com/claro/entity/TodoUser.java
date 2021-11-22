package com.claro.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todo_user")
@Data
@NamedQuery(name = "ALL_TODO_USERS", query = "select tdu from TodoUser tdu order by tdu.fullName")
@NamedQuery(name = "BY_EMAIL", query = "select tdu from TodoUser tdu where tdu.email = :email")
@NamedQuery(name = "BY_ID", query = "select tdu from TodoUser  tdu where tdu.id= :id")
@NamedQuery(name = "BY_NAME", query = "select tdu from TodoUser  tdu where tdu.fullName like :name")
public class TodoUser extends AbstractEntity { // TodoUser - database table

    @Column(length = 100)
    @NotEmpty(message = "name must be set")
    @Size(min = 5, max = 150, message = "The size of name must be between 5 and 150 characters")
    private String fullName;

    @NotEmpty(message = "An email must be set")
    @Email(message = "Email must be in the format user@domain")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, max = 100, message = "Pasword mest at min of 8 and max of 100 characters")
    @Pattern.List({
            @Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit."),
            @Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
            @Pattern(regexp = "(?=.*[A-Z])", message = "Password must contain one uppercase letter."),
            @Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.")
    })
    private String password;

}
