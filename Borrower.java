public class Borrower {
    private String name;
    private String birthDate;
    private Loan currentLoan;
    
    // 생성자
    public Borrower(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    
    // getter
    public String getBorrowerName() {
        return name;
    }
    
    public boolean isOnLoan() { // 대출 상태 확인
        return currentLoan != null;
    }

    public boolean isAvailable() { // 대출 가능한 상태 확인
        
    }

    public boolean isDuplicateBorrower(String name) {

    }

    // setter
    public void setCurrentLoan(Loan loan) {
        this.currentLoan = loan;
    }
}
