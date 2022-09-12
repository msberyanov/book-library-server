package msberyanov.model;

import lombok.Data;
import msberyanov.dto.enumeration.Status;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Data
@Table(name = "book")
public class Book {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id")
  private String id;

  @Column(name = "title")
  private String title;

  @Column(name = "author")
  private String author;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private Status status;

  @Lob
  @Column(name = "cover")
  private byte[] cover;

  @Basic
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  @Column(name = "rate")
  private Integer rate;
}
