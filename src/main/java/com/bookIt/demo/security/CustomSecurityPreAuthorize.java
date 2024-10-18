package com.bookIt.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("customCompanySecurity")
public class CustomSecurityPreAuthorize {
    public boolean hasCompanyRole(Authentication authentication, String companyId, String roleSuffix) {
        return authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority()
                        .equals(roleSuffix + "_FOR_COMPANY_" + companyId));
    }
}
