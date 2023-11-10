package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface Member1Repository extends CrudRepository<Member, Long> {
}
