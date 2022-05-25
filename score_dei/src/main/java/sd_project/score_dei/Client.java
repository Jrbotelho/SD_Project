package sd_project.score_dei;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Client")
@Table(
        name = "client",
        uniqueConstraints = {
                @UniqueConstraint(name = "client_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "client_user_unique", columnNames = "username")
        }
)
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "client_sequence"
    )

    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
           name="username",
           nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;

    @Column(
            name="password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name="email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name="contact",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contact;

    @Column(
            name="is_admin",
            nullable = false
    )
    private Boolean isAdmin;

    public Client(String username, String password, String email, String contact, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.isAdmin = isAdmin;
    }

    public Client() { }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
