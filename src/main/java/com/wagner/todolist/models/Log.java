package com.wagner.todolist.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @CreatedDate
    @JoinColumn(name = "createddate", nullable = false, updatable = true)
    private Date createdDate;

    @LastModifiedDate
    @JoinColumn(name = "lastmodifieddate", nullable = false, updatable = true)
    private Date lastModifiedDate;

    @PrePersist
    public void prePersist(){
        if (status == null){
            status = true;
        }
    }


    @JoinColumn(name = "status", nullable = false, updatable = true, columnDefinition = "true")
    private Boolean status;

    public Log() {

    }
    private Log(Long id, Date createdDate, Date lastModifiedDate){
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log log)) return false;
        return Objects.equals(getId(), log.getId()) && Objects.equals(getCreatedDate(), log.getCreatedDate()) && Objects.equals(getLastModifiedDate(), log.getLastModifiedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreatedDate(), getLastModifiedDate());
    }
}
