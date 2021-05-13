package com.desafiomv.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"name" , "cpf","opCafe1","opCafe2"})})
public class ListCafeManha implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String opCafe1;
	
	private String opCafe2;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOpCafe1() {
		return opCafe1;
	}

	public void setOpCafe1(String opCafe1) {
		this.opCafe1 = opCafe1;
	}

	public String getOpCafe2() {
		return opCafe2;
	}

	public void setOpCafe2(String opCafe2) {
		this.opCafe2 = opCafe2;
	}
	
	
	

	/*create table `cafedamanha`(
		       `user_id` int not null auto_increment,
		      `user_name` vachar(100) not null,
		      `user_cpf` vachar(11) not null unique,
		      `op_cafe1` vachar(255) not null unique,
		      `op_cafe2` vachar(255) not null,
		      primary key (`user_id`)
		)*/	
	
}
