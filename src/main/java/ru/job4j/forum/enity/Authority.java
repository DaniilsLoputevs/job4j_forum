package ru.job4j.forum.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* Lombok */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
/* Spring JPA */
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authority;

}