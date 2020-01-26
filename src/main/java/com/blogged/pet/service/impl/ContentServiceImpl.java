package com.blogged.pet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogged.pet.domain.Account;
import com.blogged.pet.domain.Content;
import com.blogged.pet.dto.ContentDto;
import com.blogged.pet.repository.ContentRepository;
import com.blogged.pet.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Content createContent(ContentDto contentDto, Account creatorAccount) {
        Content content = new Content();
        content.setHeader(contentDto.getHeader());
        content.setText(contentDto.getText());
        content.setContentCreator(creatorAccount);
        return contentRepository.save(content);
    }

    @Override
    public Iterable<Content> getAllContent() {
        return contentRepository.findAll();
    }
}
