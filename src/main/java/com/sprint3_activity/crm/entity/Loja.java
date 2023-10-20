package com.sprint3_activity.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "Loja_TBL")
@Entity
public class Loja {
	
	@Id
	@GeneratedValue
	private String id;
	private String name;
	private String cidade;
	private String país;

}
