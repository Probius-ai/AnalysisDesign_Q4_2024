import java.awt.*;
import javax.swing.*;


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
        // 대출자 등록
        registerBorrowerButton.addActionListener(e -> {
            JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
            
            JLabel nameLabel = new JLabel("대출자 이름:");
            JTextField nameField = new JTextField(10);
            JLabel birthLabel = new JLabel("생년월일(yymmdd):");
            JTextField birthField = new JTextField(10);
            
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(birthLabel); 
            panel.add(birthField);

            int result = JOptionPane.showConfirmDialog(null, panel, 
                "대출자 등록", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                String birthDate = birthField.getText();
                
                if (name.isEmpty() || birthDate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                        "모든 필드를 입력해주세요.", 
                        "입력 오류", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // 대출자 등록 메소드 호출 성공여부 받아오기
                boolean success = libraryApp.registerBorrower(name, birthDate);
                
                if (success) {
                    JOptionPane.showMessageDialog(null,
                        "대출자가 성공적으로 등록되었습니다.",
                        "등록 성공",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                        "이미 존재하는 대출자입니다.",
                        "등록 실패",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // 도서 등록
        registerBookButton.addActionListener(e -> showMessageDialog("도서 등록 창"));
        
        // 대출 가능한 도서 목록 보기
        viewLoanableBooksButton.addActionListener(e -> {
            String books = libraryApp.getLoanableBooks();
            if (books.isEmpty()) {
                JOptionPane.showMessageDialog(null, "대출 가능한 도서가 없습니다.", 
                    "도서 목록", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JTextArea textArea = new JTextArea(books);
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(300, 400));
                
                JOptionPane.showMessageDialog(null, scrollPane, 
                    "대출 가능한 도서 목록", JOptionPane.PLAIN_MESSAGE);
            }
        });

        // 대출중인 도서 목록 보기
        viewOnLoanBooksButton.addActionListener(e -> {
            String books = libraryApp.getOnLoanBooks();
            if (books.isEmpty()) {
                JOptionPane.showMessageDialog(null, "대출중인 도서가 없습니다.", 
                    "도서 목록", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JTextArea textArea = new JTextArea(books);
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(300, 400));
                
                JOptionPane.showMessageDialog(null, scrollPane, 
                    "대출중인 도서 목록", JOptionPane.PLAIN_MESSAGE);
            }
        });

        // 도서 대출
        borrowBookButton.addActionListener(e -> {

        });

        // 도서 반납
        returnBookButton.addActionListener(e -> showMessageDialog("도서 반납 창"));

        // 대출 기록 보기
        viewLoanHistoryButton.addActionListener(e -> showMessageDialog("대출 기록 보기 창"));

        // 종료
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
