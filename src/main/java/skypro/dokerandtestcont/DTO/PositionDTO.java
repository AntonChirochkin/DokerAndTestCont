package skypro.dokerandtestcont.DTO;

import lombok.*;
import skypro.dokerandtestcont.pojo.Employee;
import skypro.dokerandtestcont.pojo.Position;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PositionDTO {
    private Integer id;

    private String name;

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setName(position.getName());
        return positionDTO;
    }

    public Position toPosition() {
        Position position = new Position();
        position.setId(this.getId());
        position.setName(this.getName());
        return position;
    }

    @Override
    public String toString() {
        return "PositionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
