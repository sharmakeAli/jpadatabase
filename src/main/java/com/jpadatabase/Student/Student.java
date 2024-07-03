package com.jpadatabase.Student;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
//@Table(name = "db_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "full_name" ,nullable = false)
    String fullName;
    Integer age;
    String phone;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
  @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;


}
