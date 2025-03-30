package com.ho.edcustom.repository;

import com.ho.edcustom.entity.Like;
import com.ho.edcustom.entity.Member;
import com.ho.edcustom.entity.SharedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like,Long> {
    Optional<Like> findByMemberAndSharedItem(Member member, SharedItem sharedItem);
}
