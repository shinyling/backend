package com.shiny.ucenter.common.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author shiny
 **/
@Data
public class CommonRequest {

    private JSONObject data;

    private String token;

    private String sign;

    private String timestamp;

}
