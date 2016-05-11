package com.staterkit.cloud.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.staterkit.cloud.webapp.domain.Album;
import com.staterkit.cloud.webapp.service.AlbumService;

import java.util.List;

/**
 * @author narendra.gurram@cognizant.com
 * class for provide service to incoming album related request
 */
@RestController
public class AlbumController
{
   
    @Autowired
	private AlbumService albumService;
    
	/**
     * default Welcome page 
     * 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome(Model model)
    {
    	ModelAndView view =new ModelAndView();
    	view.setViewName("welcome");
    	return view;
    }

    /**
     * List down all albums
     * @param model
     * @return albums
     */
    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public List<Album> listProducts(Model model)
    {
        List<Album> albums = (List<Album>) albumService.getAlbumList();
        return albums;
        
    }

    /**
     *  deleting the alubums
     * @param id
     * @param model
     * @return albums
     */
    @RequestMapping(value = "/deletealbum", method = RequestMethod.GET)
    public List<Album> deleteAlbum(@RequestParam("id") String id, Model model)
    {
    	albumService.removeAlbum(id);
        List<Album> albums = albumService.getAlbumList();
        return albums;
    }

   
    /**
     * adding albums
     * @param title
     * @param artist
     * @param releaseYear
     * @param model
     * @return albums
     */
    @RequestMapping(value="/addAlbum", method = RequestMethod.POST)
    public List<Album> addAlbum
    (@RequestParam(value="title") String title,
     @RequestParam(value="artist") String artist,
     @RequestParam(value="releaseYear") String releaseYear,
     Model model)
    {

        albumService.saveAlbum(title, artist, releaseYear);
        List<Album> albums = albumService.getAlbumList();
        return albums;
    }

    /**
     * Editing the album
     * @param title
     * @param artist
     * @param releaseYear
     * @param id
     * @param model
     * @return albums
     */
    @RequestMapping(value="/editAlbum", method = RequestMethod.POST)
    public List<Album> editAlbum
            (@RequestParam(value="title") String title,
             @RequestParam(value="artist") String artist,
             @RequestParam(value="releaseYear") String releaseYear,
             @RequestParam(value="id", required=true) String id,
             Model model)
    {
        albumService.EditAlbum(id,title, artist, releaseYear);
        List<Album> albums = albumService.getAlbumList();
          return albums;
    }
}
