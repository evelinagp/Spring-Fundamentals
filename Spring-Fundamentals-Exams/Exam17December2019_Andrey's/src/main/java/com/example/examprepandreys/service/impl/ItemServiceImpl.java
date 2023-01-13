package com.example.examprepandreys.service.impl;

import com.example.examprepandreys.model.entity.Item;
import com.example.examprepandreys.model.service.ItemServiceModel;
import com.example.examprepandreys.model.view.ItemViewModel;
import com.example.examprepandreys.repository.ItemRepository;
import com.example.examprepandreys.service.CategoryService;
import com.example.examprepandreys.service.ItemService;
import com.example.examprepandreys.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {


    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    public ItemServiceImpl(ModelMapper modelMapper, CurrentUser currentUser, ItemRepository itemRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
    }


    @Override
    public void addNewItem(ItemServiceModel itemServiceModel) {
        Item item = modelMapper.map(itemServiceModel, Item.class);
        item.setCategory(categoryService.findByCategoryNameEnum(itemServiceModel.getCategory().getName()));

        itemRepository.save(item);
    }
//
//    @Override
//    public BigDecimal getTotalSum() {
//        return itemRepository.findTotalProductsSum();
//    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return itemRepository.findAll()
                .stream().map(item -> {
                    ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName().name()));
                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findItemById(String id) {
       return this.itemRepository.findById(id)
               .map(item -> {
                   ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);
                   itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName().name()));
                   return itemViewModel;
               })
               .orElse(null);
    }


    @Override
    public void buyAll() {
        itemRepository.deleteAll();
    }

    @Override
    public Integer findAllItemsCount() {
        return itemRepository.findItemsByTotalCount();

    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteItemById(id);
    }

//    @Override
//    public List<ItemViewModel> listAllItems() {
//        return this.itemRepository.findAll()
//                .stream().map(item -> modelMapper.map(item, ItemViewModel.class))
//                .collect(Collectors.toList());
//    }

//    @Override
//    public BigDecimal checkProductsSum() {
//        BigDecimal totalProductsSum = itemRepository.findTotalProductsSum();
//        if (totalProductsSum == null) {
//            totalProductsSum = BigDecimal.valueOf(0);
//        }
//        return totalProductsSum;
//    }
}
