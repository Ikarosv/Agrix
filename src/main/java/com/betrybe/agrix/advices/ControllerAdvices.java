package com.betrybe.agrix.advices;

import com.betrybe.agrix.exceptions.Exceptions;
import com.betrybe.agrix.exceptions.NotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class represents the ControllerAdvices advice.
 */
@ControllerAdvice
public class ControllerAdvices {

  @ExceptionHandler
  public ResponseEntity<String> defaultHandler(Exceptions e) {
    return ResponseEntity.status(e.getStatus()).body(e.getMessage());
  }
}
