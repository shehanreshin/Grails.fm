package edu.personal.grailsfm.artistservice.util.enums.converter;

import edu.personal.grailsfm.artistservice.util.enums.ArtistAccountStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ArtistAccountStatusConverter implements AttributeConverter<ArtistAccountStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ArtistAccountStatus status) {
        return switch (status) {
            case CONFIRMATION_PENDING -> 1;
            case UNDER_REVIEW -> 2;
            case VERIFIED -> 3;
            case BANNED -> 4;
            case DEACTIVATED -> 5;
        };
    }

    @Override
    public ArtistAccountStatus convertToEntityAttribute(Integer integer) {
        return switch (integer) {
            case 1 -> ArtistAccountStatus.CONFIRMATION_PENDING;
            case 2 -> ArtistAccountStatus.UNDER_REVIEW;
            case 3 -> ArtistAccountStatus.VERIFIED;
            case 4 -> ArtistAccountStatus.BANNED;
            case 5 -> ArtistAccountStatus.DEACTIVATED;
            default -> null;
        };
    }
}
