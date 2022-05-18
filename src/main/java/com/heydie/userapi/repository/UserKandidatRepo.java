package com.heydie.userapi.repository;

import com.heydie.userapi.entity.UserKandidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserKandidatRepo extends JpaRepository<UserKandidat, Long> {
}
