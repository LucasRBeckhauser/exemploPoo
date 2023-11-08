package com.senac.exemplo.model;

import javax.persistence.*;

@MappedSuperclass
public class EntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "id", nullable = false)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
