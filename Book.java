public class Book {
    private String title;
    private String author;
    private int uniqueNumber;
    private boolean onLoan; // 대출 여부 상태

    public Book(String title, String author, int uniqueNumber) { // 생성자
        this.title = title;
        this.author = author;
        this.uniqueNumber = uniqueNumber;
        this.onLoan = false; // 초기 상태는 대출 가능
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    // 대출 상태 확인 메소드
    public boolean isAvailable() {
        return !onLoan; // 대출 중이 아니면 true 반환
    }

    // 대출 정보 설정 메소드
    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan; // 대출 상태 변경
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", uniqueNumber=" + uniqueNumber +
                ", onLoan=" + onLoan +
                '}';
    }

    // public int compareTo(Book other) {
    //     // TODO: 카탈로그 번호 기준 정렬 구현 예정
    //     return this.uniqueNumber - other.uniqueNumber;
    // }
}
