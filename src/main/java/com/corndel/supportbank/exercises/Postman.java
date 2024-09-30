package com.corndel.supportbank.exercises;

// import kong.unirest.Unirest;

/**
 * This class represents a Message to be sent to the Postman Echo API.
 * You don't need to modify it.
 */
class Message {
  public int id;
  public String content;

  public Message(int id, String content) {
    this.id = id;
    this.content = content;
  }
}

public class Postman {
  /**
   * Echoes a message with a given id and content to the Postman Echo API, and
   * returns the response as a string.
   *
   * @param id      The id of the message
   * @param content The content of the message
   *
   * @return The response body from the Postman Echo API
   */
  public static String echoMessage(int id, String content) {
    // TODO: Create a Message object with the given id and content

    // TODO: Post the Message object to the Postman Echo API
    // Hint: Use Unirest.post()

    // TODO: Return the response body as a string of JSON
    return null;
  }

  /**
   * For debugging purposes, prints the response of the Postman Echo API to
   * `echoMessage(1, "hello")`.
   */
  public static void main(String[] args) {
    String response = echoMessage(1, "hello");
    System.out.println(response);
  }
}
