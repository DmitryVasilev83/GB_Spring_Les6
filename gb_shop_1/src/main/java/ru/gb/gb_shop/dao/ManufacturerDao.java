package ru.gb.gb_shop.dao;

import ru.gb.gb_shop.entity.Manufacturer;

public interface ManufacturerDao {
    Iterable<Manufacturer> findAll();
    Manufacturer findById(Long id);
    String findNameById(Long id);
    void insert(Manufacturer manufacturer);
    Manufacturer save(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    void deleteById(Long id);
}
