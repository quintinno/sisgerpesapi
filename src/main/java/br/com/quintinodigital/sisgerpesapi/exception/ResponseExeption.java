package br.com.quintinodigital.sisgerpesapi.exception;

import br.com.quintinodigital.sisgerpesapi.dto.ResponseExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExeption extends ResponseEntityExceptionHandler {

    private static final String EMPTY_RESULT = "O objeto pesquisado não pode ser encontrado!";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExceptionDTO> emptyResultDataAccessException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseExceptionDTO(EMPTY_RESULT, HttpStatus.NOT_FOUND.value()));
    }

}
