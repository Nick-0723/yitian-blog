package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import lombok.extern.log4j.Log4j2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class SystemLogEntityMapperTest {

    @Autowired
    private SystemLogMapper systemLogMapper;

    @Test
    public void insert() {
        SystemLogEntity log = new SystemLogEntity();
        log.setType(LogType.SYSTEM_INITIALIZATION);
        log.setStatus(LogStatus.SUCCESS);
        log.setRemark("系统初始化成功");
        log.setCreateAt(System.currentTimeMillis());
        log.setCreateBy(0l);
        log.setKeyWord("Test");
        systemLogMapper.insert(log);
        assertNotNull(log.getId());
    }

    @Test
    public void selectByPage() {
        List<SystemLogEntity> logs = systemLogMapper.selectByPage(0,10);
        assertNotNull(logs);
        logs.forEach(item -> {
            assertNotNull(item.getId());
            assertNotNull(item.getType());
            assertNotNull(item.getStatus());
            assertNotNull(item.getRemark());
            assertNotNull(item.getCreateAt());
            assertNotNull(item.getCreateBy());

        });
        assertTrue(logs.size() > 0 );
    }
}