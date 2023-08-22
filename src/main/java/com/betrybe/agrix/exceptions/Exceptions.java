package com.betrybe.agrix.exceptions;

/**
 * This class represents the Exceptions exception.
 */
public abstract class Exceptions extends RuntimeException {
  public int getStatus() {
    return status;
  }

  int status;
  /**
   * Constructor.
   *
   * @param message The exception's message.
   */
  public Exceptions(String message) {
    super(message);
  }
}
