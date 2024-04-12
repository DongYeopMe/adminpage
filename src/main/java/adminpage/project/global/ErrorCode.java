package adminpage.project.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Member
    EMAIL_ALREADY_EXIST(400, "이미 가입된 이메일입니다."),
    MEMBER_NOT_FOUND(400, "가입된 사용자가 아닙니다."),
    MEMBER_CANT_DELETE(400,"멤버 삭제를 실패했습니다."),

    PRODUCT_NOT_FOUND(400, "상품을 찾지 못했습니다."),
    PRODUCT_CANT_DELETE(400,"상품 삭제에 실패했습니다.");


    private final int status;
    private final String message;
}