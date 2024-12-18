import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LibraryGUI {
    private LibraryApplication libraryApp = new LibraryApplication();

    public LibraryGUI() {
        // Main Frame
        JFrame frame = new JFrame("도서관 관리 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);

        // Main Panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header Label
        JLabel headerLabel = new JLabel("도서관 관리 시스템", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Button Panel with GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Buttons for each functionality
        JButton registerBorrowerButton = new JButton("1. 대출자 등록");
        JButton registerBookButton = new JButton("2. 도서 등록");
        JButton viewLoanableBooksButton = new JButton("3. 대출 가능한 도서 목록 보기");
        JButton viewOnLoanBooksButton = new JButton("4. 대출중인 도서 목록 보기");
        JButton borrowBookButton = new JButton("5. 도서 대출");
        JButton returnBookButton = new JButton("6. 도서 반납");
        JButton viewLoanHistoryButton = new JButton("7. 대출 기록 보기");
        JButton exitButton = new JButton("8. 종료");

        // Add ActionListeners to open new windows
        registerBorrowerButton.addActionListener(e -> showMessageDialog("대출자 등록 창"));
        registerBookButton.addActionListener(e -> showMessageDialog("도서 등록 창"));
        
        viewLoanableBooksButton.addActionListener(e -> {
            String books = libraryApp.getLoanableBooks(); // Assuming this returns a formatted String
            JOptionPane.showMessageDialog(null, books.isEmpty() ? "대출 가능한 도서가 없습니다." : books);
        });

        viewOnLoanBooksButton.addActionListener(e -> {
            String books = libraryApp.getOnLoanBooks(); // Assuming this returns a formatted String
            JOptionPane.showMessageDialog(null, books.isEmpty() ? "대출중인 도서가 없습니다." : books);
        });

        borrowBookButton.addActionListener(e -> showMessageDialog("도서 대출 창"));
        returnBookButton.addActionListener(e -> showMessageDialog("도서 반납 창"));
        viewLoanHistoryButton.addActionListener(e -> showMessageDialog("대출 기록 보기 창"));
        exitButton.addActionListener(e -> System.exit(0));

        // Add buttons to the button panel
        buttonPanel.add(registerBorrowerButton);
        buttonPanel.add(registerBookButton);
        buttonPanel.add(viewLoanableBooksButton);
        buttonPanel.add(viewOnLoanBooksButton);
        buttonPanel.add(borrowBookButton);
        buttonPanel.add(returnBookButton);
        buttonPanel.add(viewLoanHistoryButton);
        buttonPanel.add(exitButton);

        // Footer Label
        JLabel footerLabel = new JLabel("© 2024 도서관 시스템", SwingConstants.CENTER);
        footerLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void showMessageDialog(String message) {
        JFrame dialogFrame = new JFrame(message);
        dialogFrame.setSize(300, 200);
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));

        dialogFrame.add(label);
        dialogFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryGUI::new);
    }
}
