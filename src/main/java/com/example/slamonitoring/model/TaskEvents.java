package com.example.slamonitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task_events")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)

public class TaskEvents extends AuditModel {
    @Id
    @GeneratedValue(generator = "task_events_generator")
    @SequenceGenerator(
            name = "task_events_generator",
            sequenceName = "task_events_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(columnDefinition = "VARCHAR(10)")
    public String eventType;

    @Column(columnDefinition = "VARCHAR(100)")
    public String slaName;

    @Column(columnDefinition = "INTEGER")
    private int expectedTAT;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Object taskIdentifierAttributes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_timestamp", nullable = false, updatable = false)
    private Date event_timestamp;

    public TaskEvents(String slaName, String eventType, Object task_identifier_attributes, Date date, Date date1) {
        this.slaName = slaName;
       // this.expectedTAT = expectedTAT;
        this.eventType = eventType;
        taskIdentifierAttributes = task_identifier_attributes;
        setCreatedAt(date);
        setUpdatedAt(date1);
    }

    @Override
    public String toString(){
        return this.eventType;
    }
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "question_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Question question;



    public String getSlaName() {
        return slaName;
    }

    public void setSlaName(String slaName) {
        this.slaName = slaName;
    }

//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
    //}
}
