package com.softiwa.user.emprole;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDto> getRoles() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        List<RoleDto> roleDtoList = new ArrayList<>();

        for (RoleEntity roleEntity : roleEntityList) {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(roleEntity, roleDto);
            roleDtoList.add(roleDto);
        }
        return roleDtoList;
    }
}
