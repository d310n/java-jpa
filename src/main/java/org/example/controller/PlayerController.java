package org.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.example.model.Player;
import org.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController
{

    @Autowired
    private PlayerService playerService;

    // RESTful API methods for Retrieval operations
    @GetMapping("/players")
    public List<Player> list()
    {
        return playerService.listAll();
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> get(@PathVariable Integer id) {
        try
        {
            Player player = playerService.get(id);
            return new ResponseEntity<Player>(player, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Create operation
    @PostMapping("/players")
    public ResponseEntity<Player> saveCustomer(@RequestBody Player player) {
        try
        {
            return new ResponseEntity<Player>(playerService.add(player), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // RESTful API method for Update operation
    @PutMapping("/players")
    public ResponseEntity<Player> updateCustomer(@RequestBody Player player) {
        try
        {
            return new ResponseEntity<Player>(playerService.add(player), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // RESTful API method for Delete operation
    @DeleteMapping("/players/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable Integer id) {
        try
        {
            playerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


