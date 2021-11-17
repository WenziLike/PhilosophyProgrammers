package com.philosophyprogrammers.repository;

import com.philosophyprogrammers.entity.GroupEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends PagingAndSortingRepository<GroupEntity, Long> {
    GroupEntity findByCode(String code);
}
