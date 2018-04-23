/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minoj.chat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Minoj
 */
@Entity
@Table(name = "APP.MESSAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m")
    , @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id")
    , @NamedQuery(name = "Messages.findByTitle", query = "SELECT m FROM Messages m WHERE m.title = :title")
    , @NamedQuery(name = "Messages.findByThread", query = "SELECT m FROM Messages m WHERE m.thread = :thread")
    , @NamedQuery(name = "Messages.findByPostedAt", query = "SELECT m FROM Messages m WHERE m.postedAt = :postedAt")
    , @NamedQuery(name = "Messages.distinctAuthor", query = "SELECT DISTINCT m.author FROM Messages m WHERE m.thread = :thread")
    , @NamedQuery(name = "Messages.findByReceiver", query = "SELECT m FROM Messages m WHERE m.receiver = :receiver AND m.author = :author")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "POSTED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedAt;
    @JoinColumn(name = "THREAD", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private Threads thread;
    @JoinColumn(name = "AUTHOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users author;
    @JoinColumn(name = "RECEIVER", referencedColumnName="ID")
    @ManyToOne(optional = true)
    private Users receiver;

    public Messages() {
    }

    public Messages(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Threads getThread() {
        return thread;
    }

    public void setThread(Threads thread) {
        this.thread = thread;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }
    
    public Users getReceiver() {
        return receiver;
    }
    
    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minoj.chat.Messages[ id=" + id + " ]";
    }
    
}
