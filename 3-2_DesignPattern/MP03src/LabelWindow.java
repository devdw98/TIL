import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelWindow extends FrameWindow implements MyObserver { //observer 기능 집어넣기 - updateText 바꿔주는 것(화면에 내용 업데이트)
    private JLabel label;

    public LabelWindow(String title, int x, int y, int width, int height) {
        super(title, x, y, width, height);
    }

    public void updateText(String msg) { //숫자값 받는 애들
        label.setText(msg);
        label.validate();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel();
        panel.add(label);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    @Override
    public void update(int n){
        //소수 값을 받아서 updateText 호출해주는 함수
        String str = String.valueOf(n);
        updateText(str);
    }
}
