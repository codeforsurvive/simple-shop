package com.acn.bootcamp.simpleshop.data.dto;

import com.acn.bootcamp.simpleshop.data.enums.ResourceGroup;
import lombok.*;

import java.util.List;

@Data @NoArgsConstructor
public class RoleDto {
    public RoleDto(String name, List<ResourceGroup> authorizedResources) {
        this.name = name;
        this.authorizedResources = authorizedResources;
    }

    private String name;
    private List<ResourceGroup> authorizedResources;
}
