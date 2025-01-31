package pl.kwi.chrisblog.dtos;

import pl.kwi.chrisblog.entities.CategoryEntity;

public record CategoryResponse(Iterable<CategoryEntity> categories) {}