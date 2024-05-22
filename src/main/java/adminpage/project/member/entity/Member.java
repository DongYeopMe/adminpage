package adminpage.project.member.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    @Email
    @Column(name="member_email")
    private String email;
    @Column(name="member_password")
    private String password;
    @Column(name="member_name")
    private String name;
    @Column(name="member_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name="member_rank")
    @Enumerated(EnumType.STRING)
    private Rank rank;
}
