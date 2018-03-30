package com.shiny.ucenter.api;

import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.File;

/**
 * @author shiny
 **/
public interface FileApi {

    Result uploadFile(File file);

    Result listFileByRoleId(String roleId);

}
