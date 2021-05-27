package org.example.service;

import org.example.model.Player;
import org.example.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerService
{
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> listAll()
    {
        return playerRepository.findAll();
    }

    public void save(Player player)
    {
        playerRepository.save(player);
    }

    public Player get(Integer id)
    {
        return playerRepository.findById(id).get();
    }

    public Player add(Player player) {
        return null; }

    public void delete(Integer id) {
    }
}
