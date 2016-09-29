package main.Util;

import org.apache.http.util.TextUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Yellow5A5 on 16/9/28.
 */
public class TransformerUtil {

    private String mOriginalType;
    private String mTransformType;

    public TransformerUtil setTransformType(String originalType, String transformType) {
        mOriginalType = originalType;
        mTransformType = transformType;
        return this;
    }

    public String transformTargetTo(@NotNull String originNum) {
        String output = "";
        if (TextUtils.isEmpty(originNum)) {
            return "";
        }
        try {
            String intermediateOCT = convertOct(originNum);
            output = convertTargatType(intermediateOCT);
        } catch (NumberFormatException exception) {
            output = TransformerConstant.ERROR;
        }
        return output;
    }

    private String convertOct(@NotNull String inputNumStr) throws NumberFormatException {
        String result = "";
        switch (mOriginalType) {
            case TransformerConstant.BINARY_TRANSFOR:
                result = String.valueOf(Long.parseLong(inputNumStr, 2));
                break;
            case TransformerConstant.OCTAL_TRANSFOR:
                result = String.valueOf(Long.parseLong(inputNumStr, 8));
                break;
            case TransformerConstant.DECIMAL_TRANSFOR:
                result = String.valueOf(Long.parseLong(inputNumStr, 10));
                break;
            case TransformerConstant.HEX_TRANSFOR:
                result = String.valueOf(Long.parseLong(inputNumStr, 16));
                break;

            default:
                break;
        }
        return result;
    }


    private String convertTargatType(@NotNull String inputNumStr) throws NumberFormatException {
        long inputNumLong = Long.parseLong(inputNumStr);
        String result = "";
        switch (mTransformType) {
            case TransformerConstant.BINARY_TRANSFOR:
                result = Long.toBinaryString(inputNumLong);
                break;
            case TransformerConstant.OCTAL_TRANSFOR:
                result = Long.toOctalString(inputNumLong);
                break;
            case TransformerConstant.DECIMAL_TRANSFOR:
                result = String.valueOf(inputNumLong);
                break;
            case TransformerConstant.HEX_TRANSFOR:
                result = Long.toHexString(inputNumLong);
                break;
            default:
                break;
        }
        return result;
    }

}
