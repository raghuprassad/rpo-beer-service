package com.rpo.msscbeerservice.services;

import java.util.UUID;

import com.rpo.msscbeerservice.model.BeerDto;

/**
 * @author Raghavendra.Prasad
 *
 */
public interface BeerService {
	//BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
	
	BeerDto getById(UUID beerId);

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerDto getByUpc(String upc);
    
}
