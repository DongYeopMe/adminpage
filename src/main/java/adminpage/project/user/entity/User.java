package adminpage.project.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@Table
public class User {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="company_name",nullable = false)
    private String name;

    @Column(name="email",nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDate createdAt;
    @Column(name="updated_at")
    private LocalDate updateAt;
}
