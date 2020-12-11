package ru.job4j.forum.enity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

/* Lombok */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/* Spring JPA */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "description") // illegal sql syntaxis "desc"
    private String desc;
    private Calendar created;

}
