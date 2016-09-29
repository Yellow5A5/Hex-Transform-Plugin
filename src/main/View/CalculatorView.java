package main.View;

import main.Util.TransformerConstant;
import main.Util.TransformerUtil;
import org.apache.http.util.TextUtils;

import javax.swing.*;

/**
 * Created by Yellow5A5 on 16/9/28.
 */
public class CalculatorView extends JDialog {
    private JPanel mContainer;
    private JComboBox<String> mOriginalComboBox;
    private JComboBox<String> mTransformComboBox;
    private JTextField mOriginalText;
    private JTextField mTransformText;
    private JButton mConfirmButton;

    private TransformerUtil mTransUtil;

    public CalculatorView() {
        setContentPane(mContainer);
        setTitle("Hex Transform Plugin");
        setModal(true);
        initView();
        initUtil();
        initListener();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void initView() {
        mOriginalComboBox.addItem(TransformerConstant.BINARY_TRANSFOR);
        mOriginalComboBox.addItem(TransformerConstant.OCTAL_TRANSFOR);
        mOriginalComboBox.addItem(TransformerConstant.DECIMAL_TRANSFOR);
        mOriginalComboBox.addItem(TransformerConstant.HEX_TRANSFOR);
        mTransformComboBox.addItem(TransformerConstant.BINARY_TRANSFOR);
        mTransformComboBox.addItem(TransformerConstant.OCTAL_TRANSFOR);
        mTransformComboBox.addItem(TransformerConstant.DECIMAL_TRANSFOR);
        mTransformComboBox.addItem(TransformerConstant.HEX_TRANSFOR);
    }

    private void initUtil() {
        if (TextUtils.isEmpty(mOriginType)) {
            mOriginType = TransformerConstant.BINARY_TRANSFOR;
        }
        if (TextUtils.isEmpty(mTargetType)) {
            mTargetType = TransformerConstant.BINARY_TRANSFOR;
        }
        mTransUtil = new TransformerUtil();
    }

    private void initListener() {
        mOriginalComboBox.addItemListener(e -> {
            mOriginalComboBox.setSelectedItem(e.getItem());
            mOriginType = (String) e.getItem();
        });
        mTransformComboBox.addItemListener(e -> {
            mTransformComboBox.setSelectedItem(e.getItem());
            mTargetType = (String) e.getItem();
        });

        mConfirmButton.addActionListener(e -> {
            String input = mOriginalText.getText();
            String targetNum = mTransUtil.setTransformType((String) mOriginalComboBox.getSelectedItem(), (String) mTransformComboBox.getSelectedItem())
                    .transformTargetTo(input);
            mTransformText.setText(targetNum);
        });
    }

    private String mOriginType;
    private String mTargetType;

    public void setTargetType(String mTargetType) {
        this.mTargetType = mTargetType;
    }

    public void setOriginType(String mOriginType) {
        this.mOriginType = mOriginType;
    }


    public String getOriginType() {
        return mOriginType;
    }

    public String getTargetType() {
        return mTargetType;
    }
}
