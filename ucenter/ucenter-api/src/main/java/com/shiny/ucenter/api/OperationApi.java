package com.shiny.ucenter.api;

import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.Operation;

/**
 * @author shiny
 **/
public interface OperationApi {

    Result addOperation(Operation operation);

}
