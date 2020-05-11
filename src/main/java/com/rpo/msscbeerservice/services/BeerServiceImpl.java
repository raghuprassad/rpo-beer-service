package com.rpo.msscbeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rpo.msscbeerservice.domain.Beer;
import com.rpo.msscbeerservice.model.BeerDto;
import com.rpo.msscbeerservice.repositories.BeerRepository;
import com.rpo.msscbeerservice.web.controller.NotFoundException;
import com.rpo.msscbeerservice.web.mappers.BeerMapper;

import lombok.RequiredArgsConstructor;

/**
 * @author Raghavendra.Prasad
 *
 */
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
	
	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;

	@Override
	public BeerDto getById(UUID beerId, Boolean showInventoryOnHand) {
		
		return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		
		
		Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
	}

	@Override
	public BeerDto getByUpc(String upc) {
		return  beerMapper.beerToBeerDto(beerRepository.findByUpc(upc));
	}

	@Override
	public BeerDto getById(UUID beerId) {
		return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
	}

}
