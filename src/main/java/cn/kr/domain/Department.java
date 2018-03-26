package cn.kr.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Department implements Serializable{


    @Setter
    @Getter
    @Id
    private Long id;

    //在 restful 风格中，会将所有属性都转换为JSON，
    // 给人的错觉就像懒加载失效一样
    //其实jpa 默认 就是懒加载，
    //但在restful中转换为json 时会给属性赋值，等效于调用get方法
    //在这种情况下要使用懒加载就使用 @JsonIgnore ，在转换为json时忽略此属性。
    @JsonIgnore
    @Setter
    @Getter
    //性能优化（抓取策略，懒加载）
    @Fetch(FetchMode.JOIN)//抓取策略=left join
//    @Fetch(FetchMode.SELECT)//默认的抓取策略。只使用 简单的select 语句查询，n+1 问题
//    @Fetch(FetchMode.SUBSELECT)//子查询
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

}
