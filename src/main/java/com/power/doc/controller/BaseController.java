package com.power.doc.controller;

import com.power.common.model.CommonResult;
import com.power.doc.enums.ErrorCodeEnum;
import com.power.doc.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Description:
 * 基础Controller
 *
 * @author yu 2018/06/28.
 */
public abstract class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * validate params
     *
     * @param bindingResult
     * @return
     */
    protected CommonResult validParams(BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return processBindingError(fieldError);
        }
        return ResultUtil.returnSuccess("");
    }

    /**
     * 根据spring binding 错误信息自定义返回错误码和错误信息
     *
     * @param fieldError
     * @return
     */
    private CommonResult processBindingError(FieldError fieldError){
        String code = fieldError.getCode();
        LOGGER.debug("validator error code:{}", code);
        switch (code) {
            case "NotEmpty":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_EMPTY.getCode(), fieldError.getDefaultMessage());
            case "NotBlank":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_EMPTY.getCode(), fieldError.getDefaultMessage());
            case "Pattern":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "Min":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "Max":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "DecimalMin":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "DecimalMax":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "Size":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "Digits":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "Past":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            case "Future":
                return ResultUtil.returnError(ErrorCodeEnum.PARAM_ERROR.getCode(), fieldError.getDefaultMessage());
            default:
                return ResultUtil.returnError(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }
}