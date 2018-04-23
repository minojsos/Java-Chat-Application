/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minoj.chat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Minoj
 */
@Entity
@Table(name = "APP.THREADS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Threads.findAll", query = "SELECT t FROM Threads t")
    , @NamedQuery(name = "Threads.findById", query = "SELECT t FROM Threads t WHERE t.id = :id")
    , @NamedQuery(name = "Threads.findByTitle", query = "SELECT t FROM Threads t WHERE t.title = :title")
    , @NamedQuery(name = "Threads.searchByTitle", query = "SELECT t FROM Threads t WHERE LOWER(t.title) LIKE :title")
    , @NamedQuery(name = "Threads.findByLastEdited", query = "SELECT t FROM Threads t WHERE t.lastEdited = :lastEdited")})
public class Threads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 15)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "LAST_EDITED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEdited;
    @JoinColumn(name = "AUTHOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users author;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thread")
    private Collection<Messages> messagesCollection;
    
    public Threads() {
    }

    public Threads(Integer id) {
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

    public Date getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    @XmlTransient
    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
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
        if (!(object instanceof Threads)) {
            return false;
        }
        Threads other = (Threads) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minoj.chat.Threads[ id=" + id + " ]";
    }
    
}
