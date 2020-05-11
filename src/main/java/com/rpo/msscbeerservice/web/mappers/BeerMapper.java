package com.rpo.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;

import com.rpo.msscbeerservice.domain.Beer;
import com.rpo.msscbeerservice.model.BeerDto;

/**
 * @author Raghavendra.Prasad
 *
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	BeerDto beerToBeerDto(Beer beer);
	
	Beer beerDtoToBeer(BeerDto dto);
}
