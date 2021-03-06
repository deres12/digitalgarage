package it.digitalgarage.marketplace.offertaasta.be.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/acquista")
public class AcquistaServizioController {
	
	List <ServizioDTO> esempio=new ArrayList<ServizioDTO>();
	
	@ResponseBody
	@RequestMapping(value="/accetto",method=RequestMethod.POST)
	public ResponseEntity<String> saluta(@RequestBody ServizioDTO dto){
		esempio.add(dto);
		System.out.println(""+esempio.size());
		return new ResponseEntity<String>(new String("BRAVO RICHIESTA AGGIUNTA: "+esempio.size()),HttpStatus.OK);
		
	}
	

	
	@ResponseBody
	@RequestMapping(value="/posizione/{id}",method=RequestMethod.GET)
	public ResponseEntity<ServizioDTO> trovaPos(@PathVariable int id){
		System.out.println(""+esempio.size());
		if(id<esempio.size()&&id>-1)
			return new ResponseEntity<>(esempio.get(id),HttpStatus.OK);
		else {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
	
	
	

}
