package edu.personal.grailsfm.artistservice.dto.artist;

import edu.personal.grailsfm.artistservice.util.validator.annotation.ContactNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public record CreateArtistDto(
        @Schema(example = "Michael Scott")
        @NotBlank(message = "Name is mandatory")
        String name,

        @Schema(example = "msott@dundermufflin.org")
        @Email
        String email,

        @Schema(example = "scottstots")
        @NotBlank(message = "Password is mandatory")
        String password,

        @Schema(example = "0763211347")
        @ContactNumber
        String contactNumber
) {
}
