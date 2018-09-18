package com.zrl.common.exception;

import com.zrl.modules.api.dto.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERROR_VIEW = "common/error";

    // 捕捉shiro 的异常
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(ShiroException.class)
//    @ResponseBody
//    public ResponseJSONUtil handle401(ShiroException e) {
//        return ResponseJSONUtil.errorTokenMsg("无效Token");
//    }

//    // 捕捉UnauthorizedException
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(UnauthorizedException.class)
//    public ResponseVo handle401() {
//        return ResponseVo.errorTokenMsg("无效Token");
//    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();
        if(isAjax(request)){
            return ResponseVo.errorException(e.getMessage());
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURI());
        mav.setViewName(ERROR_VIEW);

        return ResponseVo.errorMap(mav);
    }

    /**
     * 判断是否是一个ajax请求，
     * @param httpRequest
     * @return
     */
    private boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

}
