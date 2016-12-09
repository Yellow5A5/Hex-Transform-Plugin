package main;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import main.View.CalculatorView;

/**
 * Created by Yellow5A5 on 16/9/28.
 */
public class TransformAction extends AnAction {

    CalculatorView mCalculatorView;

    @Override
    public void actionPerformed(AnActionEvent e) {
        if (mCalculatorView != null && !mCalculatorView.isVisible()){
            mCalculatorView.setVisible(true);
        }else {
            mCalculatorView = new CalculatorView();
        }
    }

    @Override
    public void update(AnActionEvent e) {
        super.update(e);

    }
}
