import java.util.Objects;

public class Borrower {
    private String name;
    private String birthDate;
    private int borrowedBookCount; // 대출 중인 도서 수
    private static final int MAX_LOAN_LIMIT = 10; // 최대 대출 가능 수

    // 생성자
    public Borrower(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.borrowedBookCount = 0; // 초기 상태는 대출 없음
    }
    
    // getter
    public String getBorrowerName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
    
    public boolean isAvailable() {
        return borrowedBookCount < MAX_LOAN_LIMIT; // 최대 대출 수를 초과하지 않았는지 확인
    }

    public void incrementBorrowedBooks() {
        borrowedBookCount++;
    }

    public void decrementBorrowedBooks() {
        if (borrowedBookCount > 0) {
            borrowedBookCount--;
        }
    }

    public void display() {
        System.out.println("| Borrower 이름 : " + name + ", 생년월일 : " + birthDate + " |" );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Borrower other = (Borrower) obj;
        return Objects.equals(name, other.name) && Objects.equals(birthDate, other.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }
}
