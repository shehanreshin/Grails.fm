package edu.personal.grailsfm.artistservice.dto.artist;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateArtistDto {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;


    private String contactNumber;
}
