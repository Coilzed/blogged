package com.blogged.pet.service;

import com.blogged.pet.domain.Account;
import com.blogged.pet.domain.Content;
import com.blogged.pet.dto.ContentDto;

public interface ContentService {

    Content createContent(ContentDto contentDto, Account creatorAccount);

    Iterable<Content> getAllContent();
}
