package com.HerreraCodes.FreebiesBackend.Repository;

import com.HerreraCodes.FreebiesBackend.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
