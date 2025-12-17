package com.dkd.manage.domain.dto;

import lombok.Data;

@Data
public class TaskDetailsDto {

    private String channelCode;
    private Long expectCapacity;
    private Long skuId;
    private String skuName;
    private String skuImage;
}
