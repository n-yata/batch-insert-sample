package com.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the todoitems database table.
 *
 */
@Entity
@Table(name="todoitems")
public class Todoitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "todoitems_id_seq", sequenceName = "todoitems_id_seq", allocationSize = 100)
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "todoitems_id_seq")
	private Integer id;

	private Boolean done;

	@Column(length=255)
	private String title;

	@Column(nullable=false)
	private LocalDateTime tododate;

	@Column(name="user_id", nullable=false, length=255)
	private String userId;

	public Todoitem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDone() {
		return this.done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getTododate() {
		return this.tododate;
	}

	public void setTododate(LocalDateTime tododate) {
		this.tododate = tododate;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    @Override
    public String toString() {
        return "Todoitem [id=" + id + ", done=" + done + ", title=" + title + ", tododate=" + tododate + ", userId="
                + userId + "]";
    }

}