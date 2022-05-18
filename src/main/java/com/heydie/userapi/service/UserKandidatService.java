package com.heydie.userapi.service;

import com.heydie.userapi.entity.UserKandidat;
import com.heydie.userapi.repository.UserKandidatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserKandidatService {
    @Autowired
    private UserKandidatRepo userKandidatRepo;

    public UserKandidat create(UserKandidat userKandidat) {
      return userKandidatRepo.save(userKandidat);
    }


}
