package com.shiny.ucenter.dto;

import com.shiny.ucenter.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author DELL shiny
 * @create 2018/7/18
 */
@Data
public class UserDto extends User implements Serializable {

    private String accessToken;
}
