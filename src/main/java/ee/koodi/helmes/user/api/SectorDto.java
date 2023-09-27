package ee.koodi.helmes.user.api;

import java.util.Objects;

public class SectorDto {

    private Long id;

    private String name;

    private int spacing;

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

    public int getSpacing() {
        return spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorDto sectorDto = (SectorDto) o;
        return getSpacing() == sectorDto.getSpacing() && Objects.equals(getId(), sectorDto.getId()) && Objects.equals(getName(), sectorDto.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSpacing());
    }

    @Override
    public String toString() {
        return "SectorDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", spacing=" + spacing +
            '}';
    }
}
