package com.uao.taskmanager.TaskManager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private Long id;


  @Column
  private String name;

  @Column
  @Lob
  private String description;

  @ManyToOne
  @JoinColumn(name = "_user")
  private User user;

  @ManyToOne
  @JoinColumn(name = "_board")
  private Board board;

  @Enumerated(EnumType.STRING)
  @Column(name="state")
  private State state;

}
