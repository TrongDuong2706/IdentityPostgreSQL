package com.IdentityServicePostgreSQL.demo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserResponse {
    String id;
    String username;
    String firstName;
    String lastName;
    LocalDate dob;
}
