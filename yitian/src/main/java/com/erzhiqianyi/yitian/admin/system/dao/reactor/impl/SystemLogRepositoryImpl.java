package com.erzhiqianyi.yitian.admin.system.dao.reactor.impl;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.dao.mapper.SystemLogMapper;
import com.erzhiqianyi.yitian.admin.system.dao.reactor.SystemLogRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
@Log4j2
public class SystemLogRepositoryImpl implements SystemLogRepository {
    private final Scheduler jdbcScheduler;

    private final SystemLogMapper logMapper;

    public SystemLogRepositoryImpl(Scheduler jdbcScheduler, SystemLogMapper logMapper) {
        this.jdbcScheduler = jdbcScheduler;
        this.logMapper = logMapper;
    }

    @Override
    public Mono<SystemLogEntity> addSystemLog(SystemLogEntity entity) {
        return Mono.defer(() -> {
            logMapper.insert(entity);
            return Mono.just(entity);
        }).subscribeOn(jdbcScheduler);
    }

    @Override
    public Flux<SystemLogEntity> findSystemLogByPage(int index, int size) {
        return Flux.defer(() -> Flux.fromIterable(logMapper.selectByPage(index, size)))
                .subscribeOn(jdbcScheduler);
    }
}
