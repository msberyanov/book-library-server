package msberyanov.dto;

import lombok.Data;
import msberyanov.dto.enumeration.Status;

import java.util.Date;

@Data
public class BookDto {
  private String id;
  private String title;
  private String author;
  private Status status;
  private byte[] cover;
  private Date date;
  private Integer rate;
}
