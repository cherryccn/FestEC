package com.hjy.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * 设置字体Icons，，所有的字体图标都放在这里
 * key（）和character（）是固定写法，
 * 构造方法参数随意，最好有按照规范起的有意义
 */
public enum EcIcons implements Icon {
    icon_scan('\ue614'),
    icon_ali_pay('\ue60f');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
