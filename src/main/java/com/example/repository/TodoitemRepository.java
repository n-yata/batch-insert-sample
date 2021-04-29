package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Todoitem;

public interface TodoitemRepository extends JpaRepository<Todoitem, Integer>{

}
