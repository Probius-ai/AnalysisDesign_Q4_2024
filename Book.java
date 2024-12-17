public class Book {
    private String title;
    private String author;
    private int uniqueNumber;
    private Loan currentLoan;

    public Book(String title, String author, int uniqueNumber) { // 생성자
        this.title = title;
        this.author = author;
        this.uniqueNumber = uniqueNumber;
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
    public boolean isOnLoan() {
        return currentLoan != null;
    }

    // 대출 정보 설정 메소드
    public void setCurrentLoan(Loan loan) {
        this.currentLoan = loan;
    }

    public String toString() {
        return "책 제목: " + title + ", 저자: " + author + ", 카탈로그 번호: " + uniqueNumber;
    }

    // public int compareTo(Book other) {
    //     // TODO: 카탈로그 번호 기준 정렬 구현 예정
    //     return this.uniqueNumber - other.uniqueNumber;
    // }
}
