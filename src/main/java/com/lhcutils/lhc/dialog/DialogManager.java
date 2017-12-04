package com.lhcutils.lhc.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.lhcutils.lhc.bean.CountryBean;
import com.lhcutils.lhc.custom.PickerScrollView;
import com.lhcutils.lhc.utils.JsonUtils;
import com.lhcutils.lhc.utils.MultilingualUtil;
import com.lhcutils.lhc.xingbo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



/**
 * Created by mengyunfeng on 17/10/30.
 */

public class DialogManager {


    /**
     *
     * @param context
     * @param mCountry
     * @param mCoutryCode
     * @param defaultCode  默认国家代号
     * @param defaultName  默认国家名字
     * @return
     */
    public static String[] initmPopupDialog(final Context context, final TextView mCountry, final TextView mCoutryCode,String defaultCode,String defaultName) {
        List<CountryBean> list=new ArrayList<>();
        try {
            JSONArray jsonArray= new JSONArray(JsonUtils.getJson("CountryCode.json", context).toString());
            for (int i = 0; i <jsonArray.length() ; i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                CountryBean countryBean=new CountryBean();
                countryBean.setAb(jsonObject.getString("ab"));
                countryBean.setCountry_code(jsonObject.getString("country_code"));
                countryBean.setCountry_id(jsonObject.getInt("country_id"));
                countryBean.setCountry_name_cn(jsonObject.getString("country_name_cn"));
                countryBean.setCountry_name_en(jsonObject.getString("country_name_en"));
                countryBean.setCountry_name_ft(jsonObject.getString("country_name_ft"));
                list.add(countryBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final Dialog dialog = new Dialog(context, R.style.dialog_no_background);
        dialog.getWindow().setBackgroundDrawable(new
                ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_picker);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();

        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        lp.width = width;
        dialogWindow.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(false);
        PickerScrollView mPickerScrollView = (PickerScrollView) dialog.findViewById(R.id.dialog_picker);
        TextView mCancel = (TextView) dialog.findViewById(R.id.tv_cancel);
        TextView mConfirm = (TextView) dialog.findViewById(R.id.tv_confirm);
        mPickerScrollView.setData(list);
        mPickerScrollView.setSelected(0);
        final String[] countryCode = {defaultCode, defaultName};
        mPickerScrollView.setOnSelectListener(new PickerScrollView.onSelectListener() {
            @Override
            public void onSelect(CountryBean pickers) {
                countryCode[0] = pickers.getCountry_code();
                if (MultilingualUtil.getCurrentLocale(context).equals(Locale.CHINA)) {
                    countryCode[1] = pickers.getCountry_name_cn();
                } else if (MultilingualUtil.getCurrentLocale(context).equals(Locale.TAIWAN) || MultilingualUtil.getCurrentLocale(context).toString().equals("zh_tw")) {
                    countryCode[1] = pickers.getCountry_name_ft();
                } else {
                    countryCode[1] = pickers.getCountry_name_en();
                }

            }
        });
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (!countryCode[0].equals("")) {
                    if (mCoutryCode != null) {
                        mCoutryCode.setText("+" + countryCode[0]);
                    }
                }
                if (!countryCode[1].equals("")) {
                    if (mCountry != null) {
                        mCountry.setText(countryCode[0]);
                    }

                }

            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
        return countryCode
                ;
    }

}
