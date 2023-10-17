package com.example.actionInfo;


import com.example.action.Action;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name="actionInfos")
public class ActionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotBlank
    private Action action;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;
}
