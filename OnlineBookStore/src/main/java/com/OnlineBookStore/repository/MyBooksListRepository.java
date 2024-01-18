package com.OnlineBookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineBookStore.entity.MyBooksList;

@Repository
public interface MyBooksListRepository extends JpaRepository<MyBooksList,Integer> 
{

}
