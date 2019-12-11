package com.hjy.latte.app;

import java.util.WeakHashMap;

/**
 * 配置文件的存储与获取
 */
public class Configurator {

    private static final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);//.name()是以字符串的方式输出
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    final WeakHashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    /**
     * 检查是否配置完成
     */
    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
