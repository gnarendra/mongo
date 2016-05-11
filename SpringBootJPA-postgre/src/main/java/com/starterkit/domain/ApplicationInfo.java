package com.starterkit.domain;

/**
 * @author Anand.Kittappa@cognizant.com
 *
 */
public class ApplicationInfo
{
    private String[] profiles;
    private String[] services;

    /**
     * @param profiles
     * @param services
     */
    public ApplicationInfo(String[] profiles, String[] services) {
        this.profiles = profiles;
        this.services = services;
    }

    /**
     * @return
     */
    public String[] getProfiles() {
        return profiles;
    }

    /**
     * @param profiles
     */
    public void setProfiles(String[] profiles) {
        this.profiles = profiles;
    }

    /**
     * @return
     */
    public String[] getServices() {
        return services;
    }

    /**
     * @param services
     */
    public void setServices(String[] services) {
        this.services = services;
    }
}
