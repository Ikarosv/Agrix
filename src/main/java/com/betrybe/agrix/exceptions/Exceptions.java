package com.betrybe.agrix.exceptions;

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
