package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Item;
import edu.mum.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
 
	@RequestMapping
	public List<Item> getAll(Model model) {
		return itemService.findAll();

	}
	
	@RequestMapping("/{id}")
	public Item getItemById(@PathVariable("id") Long id) {
		return itemService.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Item processAddNewItemForm(@RequestBody Item item) {
		itemService.save(item);		
	   	return item;
	}
}
