package com.heydie.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_user_kandidat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserKandidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 10, message = "Validation : max length 10 char")
    private String name;
    @Size(max = 30, message = "Validation : max length 30 char")
    private String address;
    @Email(message = "Validation : email format acceptable")
    private String email;
}
