package com.heydie.userapi.service;

import com.heydie.userapi.entity.OfficeKandidat;
import com.heydie.userapi.repository.OfficeKandidatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeKandidatService {
    @Autowired
    private OfficeKandidatRepo officeKandidatRepo;

    public OfficeKandidat create(OfficeKandidat  officeKandidat) {
        return officeKandidatRepo.save(officeKandidat);
    }


}
