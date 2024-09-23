package ro.animals_adoption_center.adoption.payload;

import lombok.Builder;

@Builder
public record ResponsePayload<T>(T data, String message) {
}
