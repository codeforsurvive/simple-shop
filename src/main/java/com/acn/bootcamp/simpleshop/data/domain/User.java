package com.acn.bootcamp.simpleshop.data.domain;
import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity(name = SchemaDefinition.USER)
@Getter
@AllArgsConstructor
public class User extends AuditableDomainBase {

    public User(@NotNull String username, @NotNull String password, @NotNull Role role, @NotNull Boolean locked) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.locked = locked;
    }

    public User(@NotNull String username, @NotNull String password, @NotNull Role role) {
        this(username, password, role, false);
    }

    @NotNull @Column(length = 32, unique = true)
    private String username;

    @NotNull @Column(length = 64)
    private String password;

    @NotNull
    private Boolean locked;

    @NotNull @Column(length = 32)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person owner;
}
