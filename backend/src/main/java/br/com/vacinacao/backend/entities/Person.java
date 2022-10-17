package br.com.vacinacao.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{socialId.notBlank}")
    private String socialId;

    @NotBlank(message = "{name.notBlank}")
    @Size(max = 60, min = 2, message = "{name.size}")
    private String name;

    @NotBlank(message = "{age.notBlank}")
    private Integer age;

    @NotBlank(message = "riskGroup.notBlank")
    private Boolean riskGroup;

    public Person() {
    }

    public Person(String socialId, String name, Integer age, Boolean riskGroup) {
        this.socialId = socialId;
        this.name = name;
        this.age = age;
        this.riskGroup = riskGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getRiskGroup() {
        return riskGroup;
    }

    public void setRiskGroup(Boolean riskGroup) {
        this.riskGroup = riskGroup;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
