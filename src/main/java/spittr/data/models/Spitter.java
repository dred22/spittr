package spittr.data.models;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Spitter {
    private Long id;
    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;
    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;
    @NotNull
    @Size(min=2, max=30, message="{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min=2, max=30, message="{lastName.size}")
    private String lastName;
    @NotNull
    @Email( message="{email.valid}")
    private String email;

    private Date ts;

    public Spitter(){

    }

    public Spitter(String username, Date ts){
        this.username = username;
        this.ts = ts;
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(String username, String password, String firstName, String lastName) {
        this(null, username, password, firstName, lastName);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "username", "password", "firstName", "lastName");
    }
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "username", "password", "firstName", "lastName");
    }

    @Override
    public String toString() {
        return "Spitter{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", ts=" + ts +
               '}';
    }
}