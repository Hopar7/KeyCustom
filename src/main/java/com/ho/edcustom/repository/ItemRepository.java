package com.ho.edcustom.repository;

import com.ho.edcustom.entity.Item;
import com.ho.edcustom.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findItemByEmail(String email);
}
