public class Borrower {
    private String name;
    private Loan currentLoan;
    
    // 생성자
    public Borrower(String name) {
        this.name = name;
        this.currentLoan = null;
    }
    
    // getter
    public String getName() {
        return name;
    }
    
    public boolean isOnLoan() { // 대출 상태 확인
        return currentLoan != null;
    }

    public boolean isAvailable() { // 대출 가능한 상태 확인
        
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCurrentLoan(Loan loan) {
        this.currentLoan = loan;
    }
}
