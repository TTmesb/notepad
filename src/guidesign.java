import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class guidesign {
    public guidesign() {
        JMenu menu = new JMenu("Arkiv");
        menubar = new JMenuBar();
        JMenuItem spara = new JMenuItem("Spara din text bror");
        JMenuItem ny = new JMenuItem("Ny Textfil");
        JMenuItem open = new JMenuItem("Öppna ");
        donate = new JMenuItem("Donera");

        menu.add(donate);
        menu.add(open);
        menu.add(ny);
        menu.add(spara);
        menubar.add(menu);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skrivyta.setText("");
            }
        });
        copyTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clipboard kopiera = Toolkit.getDefaultToolkit().getSystemClipboard();
                kopiera.setContents(new StringSelection(skrivyta.getText()), null);

            }
        });
        donate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().browse(new URL("https://streamlabs.com/tmesb/tip").toURI());
                } catch (Exception e) {}
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad 2.0++");
        guidesign gui = new guidesign();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        frame.setJMenuBar(gui.menubar);
        frame.setPreferredSize(new Dimension(800,400));

    }
    private JPanel panel1;
    private JTextArea skrivyta;
    private JButton clearButton;
    private JButton copyTextButton;
    private JMenuItem donate;
    JMenuBar menubar;
}
