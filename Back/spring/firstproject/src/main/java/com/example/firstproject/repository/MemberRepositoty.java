package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepositoty extends CrudRepository<Member,Long> {

}
