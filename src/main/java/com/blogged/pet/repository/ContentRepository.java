package com.blogged.pet.repository;

import com.blogged.pet.domain.Content;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContentRepository extends PagingAndSortingRepository<Content, Long> {
}
