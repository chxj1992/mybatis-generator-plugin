package cn.kt.setting;

import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import cn.kt.constant.ExtendFeatureEnum;
import cn.kt.model.Config;

/**
 * @author chenxiaojing
 * @since 2020-05-20
 */
public class CheckBoxHolder {

    private static Map<String, JCheckBox> checkBoxMap = new HashMap<>();

    /**
     * 获取配置Feature对应的checkbox对象
     * @param config
     * @param featureEnum
     * @return
     */
    public static JCheckBox fetchFeatureCheckBox(Config config, ExtendFeatureEnum featureEnum) {
        JCheckBox jCheckBox;
        String key = getKey(config, featureEnum);
        if (checkBoxMap.containsKey(key)) {
            jCheckBox = checkBoxMap.get(key);
        } else {
            jCheckBox = new JCheckBox(featureEnum.getDesc());
            jCheckBox.setSelected(featureEnum.isDefaultChecked());
            checkBoxMap.put(key, jCheckBox);
        }
        return jCheckBox;
    }

    private static String getKey(Config config, ExtendFeatureEnum featureEnum) {
        return config.getName() + featureEnum.toString();
    }
}
