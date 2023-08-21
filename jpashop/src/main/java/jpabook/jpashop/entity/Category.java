package jpabook.jpashop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category {

  @Id
  @GeneratedValue
  @Column(name = "category_id")
  private Long id;

  private String name;

  @OneToMany(mappedBy = "category")
  private List<CategoryItem> items = new ArrayList<>();

  // 여기서 포인트는 자기 자신끼리 양방향관계를 만든
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  private List<Category> child = new ArrayList<>();

  //== 연관관계 메서드 ==//
  public void addChildCategory(Category child) {
    this.child.add(child);
    child.setParent(this);
  }

}
