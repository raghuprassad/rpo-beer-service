package com.rpo.msscbeerservice.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Raghavendra.Prasad
 *
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	@Null
	private UUID id;
	
	@Null
	private Integer version;
	
	@Null
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
	private OffsetDateTime createdDate;
	
	@Null
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
	private OffsetDateTime lastModifiedDate;
	
	@NotBlank
	private String beerName;
	
	@NotNull
	private BeerStyleEnum beerStyle;
	
	@NotNull
	private String upc;
	
	@Positive
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private BigDecimal price;
	
	private Integer quantityOnHand;
}
