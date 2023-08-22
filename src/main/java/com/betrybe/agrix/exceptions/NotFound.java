package com.betrybe.agrix.exceptions;

/**
 * This class represents the NotFound exception.
 */
public class NotFound extends Exceptions {
  /**
   * Constructor.
   *
   * @param message The exception's message.
   */
  public NotFound(String message) {
    super(message);
    this.status = 404;
  }
}
