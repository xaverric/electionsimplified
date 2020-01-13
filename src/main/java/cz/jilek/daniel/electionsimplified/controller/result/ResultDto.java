package cz.jilek.daniel.electionsimplified.controller.result;

import lombok.Data;

@Data
public class ResultDto {

    private String partyName;
    private String candidateColor;
    private String candidateName;
    private Long votes;
    private boolean filtered = true;

}
