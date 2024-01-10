package crush.myList.global.schema;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Schema(name = "CheckNickname_200", description = "닉네임 중복 검사 성공 응답")
public class ChangeNickname_200 {
    @NotNull
    @Schema(example = "200")
    private int status;
    @NotBlank
    @Schema(example = "사용 가능한 닉네임")
    private String message;
    @NotBlank
    @Schema(example = "crush")
    private String data;
}
