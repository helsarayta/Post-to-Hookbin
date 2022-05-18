package com.heydie.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_office_kandidat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeKandidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Validation : numeric only ")
    private Integer nid;
    @NotNull(message = "Validation : numeric only ")
    private Integer officeId;
}
