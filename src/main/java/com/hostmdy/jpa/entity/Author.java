package com.hostmdy.jpa.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;
	private String fname;
	private String lname;
	private Integer age;
	private String email;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	public Author() {
		super();
	}

	public Author(String fname, String lname, Integer age, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;

	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, authorId, email, fname, lname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(age, other.age) && Objects.equals(authorId, other.authorId)
				&& Objects.equals(email, other.email) && Objects.equals(fname, other.fname)
				&& Objects.equals(lname, other.lname);
	}

}
