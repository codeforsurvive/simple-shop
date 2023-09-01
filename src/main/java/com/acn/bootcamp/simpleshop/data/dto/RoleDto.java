package com.acn.bootcamp.simpleshop.data.dto;

import com.acn.bootcamp.simpleshop.data.enums.ResourceGroup;
import com.acn.bootcamp.simpleshop.data.enums.Role;

import java.util.List;
public record RoleDto(Role name, List<ResourceGroup> authorizedResources) {
}
