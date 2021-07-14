package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class PrimoController {

    Random r = new Random();
    private MyService myService;

    @Autowired
    public PrimoController(MyService myService){
        this.myService=myService;
    }


    @RequestMapping(value = "/webnumero", method = RequestMethod.GET) // ritorna il valore del numero casuale nell'url quando vado su postman
    public int ritornaNumeroCasuale(){
        return r.nextInt();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Partita nuovaPartita(){
        return myService.nuovaPartita();
    }

    @RequestMapping(value = "/reset/{matchID}", method = RequestMethod.PUT)
    public Partita resetPartita(@PathVariable String matchID){
        return myService.resetPartita(matchID);
    }

    // /move/abcd/1/1
    @RequestMapping(value = "/move/{idPartita}/{pos_i}/{pos_j}", method = RequestMethod.PUT)
    public Partita inserimentoSimbolo(
            @RequestHeader String userid,
            @PathVariable String idPartita,
            @PathVariable Integer pos_i,
            @PathVariable Integer pos_j){
        return myService.movimento(idPartita, userid, pos_i, pos_j);
    }

    @RequestMapping(value = "/back/{idPartita}",method = RequestMethod.GET)
    public Partita back(@PathVariable String idPartita){
        return myService.back(idPartita);
    }

    @RequestMapping(value = "/controlloVittoria/{idPartita}", method = RequestMethod.GET)
    public Partita controlloVIttoria (@PathVariable String idPartita){
        return myService.controlloVittoria(idPartita);
    }


}
