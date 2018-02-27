package com.study.www.model.mapper;

import com.study.www.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * ConfigRepository: JPAis Config
 *
 * @date :  2018/2/24    14:06
 **/
public interface ConfigRepository extends JpaRepository<Config,Long> {

    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update Config con set  con.status=:status where con.id=:id")
    int setStatusById(@Param("status")String status,@Param("id")Long id);


    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update Config con set  con.cron=:cron where con.id=:id")
    int setScheduleById(@Param("cron")String cron,@Param("id") Long id);
}
