package com.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.entity.PlayList;

public interface PlaylistRepository extends JpaRepository<PlayList, Integer>
{

}
