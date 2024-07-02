package org.zerock.mallapi.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.mallapi.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

  @EntityGraph(attributePaths = {"memberRoleList"}) // DataJpa 에서 fetch 조인을 하기 위한 설정
  @Query("select m from Member m where m.email = :email")
  Member getWithRoles(@Param("email") String emil);
}
