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
    public String getName() {
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

    @Override
    public String toString() {
        return "Borrower{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", borrowedBookCount=" + borrowedBookCount +
                '}';
    }
}
