package com.dkd.manage.domain.dto;


import lombok.Data;

import java.util.List;

@Data
public class TaskDto {

    private Long createType;
    private String innnerCode;
    private Long userId;
    private Long assignorId;
    private Long productTypeId;
    private String desc;
    private List<TaskDetailsDto> details;
}
