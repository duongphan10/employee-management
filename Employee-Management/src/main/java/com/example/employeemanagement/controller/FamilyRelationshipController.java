package com.example.employeemanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.employeemanagement.base.RestApiV1;
import com.example.employeemanagement.base.VsResponseUtil;
import com.example.employeemanagement.constant.UrlConstant;
import com.example.employeemanagement.domain.dto.request.FamilyRelationshipRequestDto;
import com.example.employeemanagement.security.CurrentUser;
import com.example.employeemanagement.security.UserPrincipal;
import com.example.employeemanagement.service.FamilyRelationshipService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestApiV1
public class FamilyRelationshipController {
    private final FamilyRelationshipService familyRelationshipService;

    @Tag(name = "family-relationship-controller")
    @Operation(summary = "API get family relationship by id")
    @GetMapping(UrlConstant.FamilyRelationship.GET_BY_ID)
    public ResponseEntity<?> getById(@PathVariable int id,
                                     @Parameter(name = "principal", hidden = true)
                                     @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(familyRelationshipService.getById(id, user.getId()));
    }

    @Tag(name = "family-relationship-controller")
    @Operation(summary = "API get all family relationship by employee id")
    @GetMapping(UrlConstant.FamilyRelationship.GET_ALL_BY_EMPLOYEE_ID)
    public ResponseEntity<?> getAllByEmployeeId(@PathVariable int employeeId,
                                                @Parameter(name = "principal", hidden = true)
                                                @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(familyRelationshipService.getAllByEmployeeId(employeeId, user.getId()));
    }

    @Tag(name = "family-relationship-controller")
    @Operation(summary = "API create family relationship")
    @PostMapping(UrlConstant.FamilyRelationship.CREATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> create(@PathVariable int employeeId,
                                    @Valid @RequestBody List<FamilyRelationshipRequestDto> familyRelationshipRequestDtos,
                                    @Parameter(name = "principal", hidden = true)
                                    @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(familyRelationshipService.create(user.getId(), employeeId, familyRelationshipRequestDtos));
    }

    @Tag(name = "family-relationship-controller")
    @Operation(summary = "API update family relationship by id")
    @PatchMapping(UrlConstant.FamilyRelationship.UPDATE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> updateById(@PathVariable int id,
                                        @Valid @RequestBody FamilyRelationshipRequestDto familyRelationshipRequestDto,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(familyRelationshipService.updateById(id, familyRelationshipRequestDto, user.getId()));
    }

    @Tag(name = "family-relationship-controller")
    @Operation(summary = "API delete family relationship by id")
    @DeleteMapping(UrlConstant.FamilyRelationship.DELETE)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<?> deleteById(@PathVariable int id,
                                        @Parameter(name = "principal", hidden = true)
                                        @CurrentUser UserPrincipal user) {
        return VsResponseUtil.success(familyRelationshipService.deleteById(id, user.getId()));
    }
}
