package be.vdab.muziek.controllers;

import be.vdab.muziek.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService service;
    public AlbumController(AlbumService service) {
        this.service = service;
    }
    @GetMapping("{id}")
    public ModelAndView film(@PathVariable int id) {
        var modelAndView = new ModelAndView("albumDetail");
        service.findById(id).ifPresent(album->{
            modelAndView.addObject("album",album);
            modelAndView.addObject("tracks",album.getTracks());
            modelAndView.addObject("tracks",album.getTracks());
            modelAndView.addObject("totaalTijd",album.totalTime());
        });
        return modelAndView;
    }
    @PostMapping("{id}")
    public String score(@PathVariable int id,int score){
        service.update(id,score);
        return "redirect:/";
    }
}
