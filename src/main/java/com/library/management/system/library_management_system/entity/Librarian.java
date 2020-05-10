package com.library.management.system.library_management_system.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Librarian implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer librarianId;
    private String name;
    private String login;
    private String password;
}
