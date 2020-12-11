package ru.job4j.forum.enity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

/* Lombok */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/* Spring JPA */
public class Post {
    private int id;
    private String name;
    private String desc;
    private Calendar created;

}
