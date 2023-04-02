package com.NewStudent.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document


public class DbSequence {
    @Id
    private String id;
    private String SeqNo;

    public DbSequence() {
    }

    public DbSequence(String id, String seqNo) {
        this.id = id;
        SeqNo = seqNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeqNo() {
        return SeqNo;
    }

    public void setSeqNo(String seqNo) {
        SeqNo = seqNo;
    }

    }

