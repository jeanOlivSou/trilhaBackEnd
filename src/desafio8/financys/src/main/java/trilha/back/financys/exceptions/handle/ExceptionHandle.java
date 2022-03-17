package trilha.back.financys.exceptions.handle;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import trilha.back.financys.exceptions.DivideByZeroException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultException> handle(MethodArgumentNotValidException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage(
                e.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .findFirst()
                        .get()
                        .getDefaultMessage()
        );
        defaultException.setDateTime(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);
    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<DefaultException> notFound(NoSuchElementException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage("Registro não encontrado");
        defaultException.setDateTime(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    ResponseEntity<DefaultException> notFound(EmptyResultDataAccessException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage("Registro não encontrado");
        defaultException.setDateTime(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<DefaultException> jsonError(HttpMessageNotReadableException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage("Erro de sintaxe do Json.");
        defaultException.setDateTime(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);

    }


    @ExceptionHandler(DivideByZeroException.class)
    ResponseEntity<DefaultException> divideByZero(DivideByZeroException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage(e.getLocalizedMessage());
        defaultException.setDateTime(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);
    }


    @ExceptionHandler(NullPointerException.class)
    ResponseEntity<DefaultException> byNomeNotFound(NullPointerException e){
        DefaultException defaultException = new DefaultException();

        defaultException.setMessage("Nome não encontrado");
        defaultException.setDateTime(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity
                .status(defaultException.getStatus())
                .body(defaultException);
    }




}
