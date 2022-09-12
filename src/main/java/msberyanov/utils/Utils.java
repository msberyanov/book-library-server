package msberyanov.utils;

public class Utils {
  private static final String LOG_MESSAGE = "The `%s` method was called";

  private static final String NO_BOOK_MESSAGE = "The book with id `%s` was not found";

  public static String getLogMessage(String method) {
    return String.format(LOG_MESSAGE, method);
  }

  public static String getNoBookMessage(String id) {
    return String.format(NO_BOOK_MESSAGE, id);
  }
}
