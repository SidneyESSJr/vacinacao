package br.com.vacinacao.backend.domains;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{name.notBlank}")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private Boolean worksOnWeekend;

    @OneToMany(mappedBy = "location")
    private Set<Scheduling> schedules = new HashSet<>();

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public Location() {
    }

    public Location(String name, City city, String openingTime, String closingTime, Boolean worksOnWeekend) {
        this.name = name;
        this.city = city;
        this.openingTime = LocalTime.parse(closingTime, formatter);
        this.closingTime = LocalTime.parse(closingTime, formatter);
        this.worksOnWeekend = worksOnWeekend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getOpeningTime() {
        return formatter.format(closingTime);
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = LocalTime.parse(openingTime);
    }

    public String getClosingTime() {
        return formatter.format(closingTime);
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = LocalTime.parse(closingTime);
    }

    public Boolean getWorksOnWeekend() {
        return worksOnWeekend;
    }

    public void setWorksOnWeekend(Boolean worksOnWeekend) {
        this.worksOnWeekend = worksOnWeekend;
    }

    public Set<Scheduling> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Scheduling> schedules) {
        this.schedules = schedules;
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
        Location other = (Location) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
