package skypro.dokerandtestcont.DTO;

import skypro.dokerandtestcont.pojo.ReportWithPath;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ReportWithPathDTO implements Serializable {
    private Integer id;
    private String path;


    public static ReportWithPathDTO fromReportWithPath(ReportWithPath reportWithPath) {
        ReportWithPathDTO reportWithPathDTO = new ReportWithPathDTO();
        reportWithPathDTO.setId(reportWithPath.getId());
        reportWithPathDTO.setPath(reportWithPath.getPath());
        return reportWithPathDTO;
    }

    public ReportWithPath toReportWithPath() {
        ReportWithPath reportWithPath = new ReportWithPath();
        reportWithPath.setId(this.getId());
        reportWithPath.setPath(this.getPath());
        return reportWithPath;
    }
}
