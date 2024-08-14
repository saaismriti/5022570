package com.library.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameEmailProjection {
    Long getId();
    String getName();
    String getEmail();

    // Custom projection field using @Value annotation
    @Value("#{target.name + ' (' + target.email + ')'}")
    String getFullNameAndEmail();
}
