package com.example.agribotproj.domain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "users")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class UserDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userID;
    @Column(name = "username" , nullable = false, unique = true)
    private String username;
    @Column(name = "password" , nullable = false)
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Column(name = "location")
    private String location ;
    @Column(name="account_status")
    private boolean accountStatus; // New field for user's active status

    public UserDBO(Long userID, String username, String password, String firstName, String lastName, String phoneNumber, String location, boolean accountStatus) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.accountStatus = accountStatus;
    }
}