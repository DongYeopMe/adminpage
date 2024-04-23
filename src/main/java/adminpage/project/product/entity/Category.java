package adminpage.project.product.entity;

import lombok.Getter;

public enum Category {
    Tshirt("티셔츠"),
    Sweatshirt("스웻셔츠"),
    Dressshirt("와이셔츠"),
    Sweater("스웨터"),
    Cardigan("가디건"),
    Jean("청바지"),
    Slacks("슬랙스");

    @Getter
    private final String desciption;

    Category(String desciption) {
        this.desciption = desciption;
    }
    public String getDescription() {
        return this.desciption;
    }
}
