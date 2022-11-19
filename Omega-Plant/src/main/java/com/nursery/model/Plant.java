package com.nursery.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;
	
	@NotNull
	private Integer plantHeight;

	@NotNull
	private String plantSpread;
	
	private String commonName;
	
	private String bloomTime;
	
	private String medicinalUse;
	
	@NotNull
	private String difficultyLevel;
	
	private String temperature;
	
	@NotNull
	private String typeOfPlant;
	
	private String plantDescription;
	
	@NotNull
	private Integer plantsStock;
	
	@NotNull
	private Integer plantsCost;

	
	
}