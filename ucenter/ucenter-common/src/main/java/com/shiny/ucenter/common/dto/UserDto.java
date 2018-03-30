package com.shiny.ucenter.common.dto;

import com.shiny.ucenter.common.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shiny
 **/
@Data
public class UserDto extends User implements Serializable {

    private String token;

    public UserDto(){
        super();
    }
}
