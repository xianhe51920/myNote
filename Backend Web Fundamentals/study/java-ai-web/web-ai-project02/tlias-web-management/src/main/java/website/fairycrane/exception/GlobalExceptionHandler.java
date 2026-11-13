package website.fairycrane.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import website.fairycrane.pojo.Result;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错了~",e);
        return Result.error("程序出错了，请联系管理员");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        String message = e.getMessage();
        String errMsg = message.substring(message.indexOf("Duplicate entry")).split(" ")[2];
        return Result.error(errMsg+"已存在");
    }
}
