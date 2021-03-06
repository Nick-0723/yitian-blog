package com.erzhiqianyi.yitian.admin.system.service;

import com.erzhiqianyi.yitian.admin.system.model.dto.SystemLogDto;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemLogRequest;
import com.erzhiqianyi.yitian.common.model.dto.PageDto;
import reactor.core.publisher.Mono;

public interface SystemLogService {
    Mono<SystemLogDto> addSystemLog(SystemLogDto log);

    Mono<PageDto<SystemLogDto>> getSystemLog(SystemLogRequest request);
}
