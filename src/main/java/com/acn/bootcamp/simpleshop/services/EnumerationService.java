package com.acn.bootcamp.simpleshop.services;

import com.acn.bootcamp.simpleshop.data.domain.Enumeration;
import com.acn.bootcamp.simpleshop.data.enums.EnumGroup;
import com.acn.bootcamp.simpleshop.data.enums.Role;
import com.acn.bootcamp.simpleshop.data.repositories.EnumerationGroupRepository;
import com.acn.bootcamp.simpleshop.data.repositories.EnumerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnumerationService {

    private final EnumerationGroupRepository groupRepository;
    private final EnumerationRepository enumerationRepository;
    @Autowired
    public EnumerationService(EnumerationGroupRepository groupRepository, EnumerationRepository enumerationRepository){
        this.groupRepository = groupRepository;
        this.enumerationRepository = enumerationRepository;
    }
}
