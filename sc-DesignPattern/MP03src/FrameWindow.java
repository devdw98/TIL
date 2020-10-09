import javax.swing.*;
import java.awt.event.WindowListener;

/*
JFrame 을 이용해 윈도우를 만들기 위한 클래스
 */
public abstract class FrameWindow {
    private JFrame frame;

    public FrameWindow(String title, int x, int y, int width, int height) {
        frame = createWindow(title, x, y, width, height);
    }

    public FrameWindow(String title, int x, int y, int width, int height, WindowListener lis) {
        frame = createWindow(title, x, y, width, height);
        frame.addWindowListener(lis);
    }

    public JFrame createWindow(String title, int x, int y, int width, int height) {
        JFrame frame;
        frame = new JFrame(title);
        frame.setBounds(x, y, width, height);
        JPanel panel = createPanel(width, height); //실제 페널을 만들어주는 것
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    public void closeWindow() {
        frame.setVisible(false);
        frame.dispose();
    }

    public void addWindowListener(WindowListener lis) {
        frame.addWindowListener(lis);
    }

    public abstract JPanel createPanel(int width, int height); //실제로 패널에 들어가는 내용을 만들어냄
}
