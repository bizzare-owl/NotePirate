package org.notepirate.controllers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpUserDto {

    private String username;
    private String password;

}
