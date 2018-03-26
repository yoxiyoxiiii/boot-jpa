package cn.kr.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Employee implements Serializable{

    @Id
    @Setter
    @Getter
    private Long id;

    @Column
    @Setter
    @Getter
    private String username;

    @JsonIgnore
    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

}
