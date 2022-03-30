import javax.swing.*;
import java.util.Locale;

public class FrameMain extends JFrame {
    private JTextField textFieldN;
    private JTextField textFieldK;
    private JPanel panelMain;
    private JButton buttonSolve;
    private JTextField textFieldAnswer;

    public FrameMain() {
        Locale.setDefault(Locale.ROOT);
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        buttonSolve.addActionListener(e -> {
            try {
                int n = Integer.parseInt(textFieldN.getText());
                int k = Integer.parseInt(textFieldK.getText());
                check(n, k);

                SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
                for (int i = 1; i <= n; i++) {
                    list.addLast(i);
                }

                textFieldAnswer.setText(Integer.toString(list.getNumberOfLastPerson(k)));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void check(int n, int k) throws Exception {
        if (k > n || n == 0 || k == 0) {
            throw new Exception("Ошибка в введённых данных");
        }
    }
}