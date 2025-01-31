package pl.kwi.chrisblog.dtos;

import java.util.List;

import pl.kwi.chrisblog.entities.TagEntity;

public record TagResponse(List<TagEntity> tags) {}