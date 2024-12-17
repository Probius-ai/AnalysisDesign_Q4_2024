import java.util.Objects;

public class Book implements Comparable<Book> {
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
    public String getBookTitle() {
        return title;
    }

    public String getBookAuthor() {
        return author;
    }

    public int getBookUniqueNumber() {
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

    @Override
    public int compareTo(Book other) {
        // uniqueNumber 기준으로 비교
        return Integer.compare(this.uniqueNumber, other.uniqueNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return uniqueNumber == other.uniqueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueNumber);
    }
}
