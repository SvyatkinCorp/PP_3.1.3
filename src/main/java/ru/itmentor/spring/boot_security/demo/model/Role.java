package ru.itmentor.spring.boot_security.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;
//
@Entity
@Table(name = "roles")

public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    @JsonIgnore
    private String name;

    public Role(Long id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
    public Role() {

    }
    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public Set<User> getUsers() {
        return users;
    }

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}