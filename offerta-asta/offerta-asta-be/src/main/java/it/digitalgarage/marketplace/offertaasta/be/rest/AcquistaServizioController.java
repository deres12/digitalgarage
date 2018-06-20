package it.digitalgarage.marketplace.offertaasta.be.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/acquista")
public class AcquistaServizioController {
	
	@ResponseBody
	@RequestMapping(value="/accetto",method=RequestMethod.POST)
	public ResponseEntity<ServizioDTO> saluta(@RequestBody ServizioDTO dto){
		return new ResponseEntity<>(new ServizioDTO(dto),HttpStatus.OK);
		/*if(dto.getNome()!=null){
			return new ResponseEntity<>(new ServizioDTO(dto),HttpStatus.OK);
		}else{
			return new ResponseEntity<>(new ServizioDTO(dto),HttpStatus.BAD_REQUEST);
		}*/
		
	}

}
