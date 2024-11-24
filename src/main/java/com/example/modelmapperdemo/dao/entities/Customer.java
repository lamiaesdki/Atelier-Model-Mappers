package com.example.modelmapperdemo.dao.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Customer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String name;
    private String email;
    private String password;
    public static class CustomerBuilder {
        private Long id;
        private String name;
        private String email;
        private String password;

    }
}
