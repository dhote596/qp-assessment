package com.qpassessment.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<User> userSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
