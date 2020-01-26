package com.blogged.pet.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "Content")
@Table(name = "content")
public class Content implements Serializable {

    private static final long serialVersionUID = 1796189323208487227L;

    @Id
    @GeneratedValue
    private Long contentId;

    @Column(name = "header", length = 100)
    @NotBlank
    private String header;

    @Column(name = "text", length = 500)
    @NotBlank
    private String text;

    @Column(name = "approved_time")
    @DateTimeFormat(pattern = "dd-MM-yyyy/hh:mm")
    private LocalDateTime approvedTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Account contentCreator;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account approvedBy;

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(LocalDateTime approvedTime) {
        this.approvedTime = approvedTime;
    }

    public Account getContentCreator() {
        return contentCreator;
    }

    public void setContentCreator(Account contentCreator) {
        this.contentCreator = contentCreator;
    }

    public Account getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Account approvedBy) {
        this.approvedBy = approvedBy;
    }
}
