package tv.wallbase.gateway.service;


import tv.wallbase.common.system.SystemConfig;

/**
 *
 * @author Administrator
 */
public interface ConfigService {

    public String get();

    public SystemConfig getSystemConfig();
}
