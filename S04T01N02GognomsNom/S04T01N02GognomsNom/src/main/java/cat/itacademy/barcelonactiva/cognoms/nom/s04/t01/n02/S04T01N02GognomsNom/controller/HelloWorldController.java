package cat.itacademy.barcelonactiva.cognoms.nom.s04.t01.n02.S04T01N02GognomsNom.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloWorldController {
    @GetMapping("/HelloWorld")
    @ResponseBody
    public ResponseEntity<String> saluda(
            @RequestParam(name = "nom", required = false, defaultValue = "UNKNOWN") String nom) {
        String hola = "Hola, " + nom + ". Estàs executant un projecte Maven";
        return new ResponseEntity<String>(hola, HttpStatus.OK);
    }


    @RequestMapping({"/HelloWorld2/{nom}","/HelloWorld2"})
    @ResponseBody
    public ResponseEntity<String> saluda2(@PathVariable(required = false) Optional<String> nom) {


        if (nom.isPresent()) {

            String hola = "Hola, " + nom.toString().replaceAll("Optional", "") + ". Estàs executant un projecte Maven";
            return new ResponseEntity<String>(hola, HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("UNKNOWN",HttpStatus.OK);
        }


    }
}
