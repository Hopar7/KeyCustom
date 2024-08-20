package com.ho.edcustom.repository;

import com.ho.edcustom.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
