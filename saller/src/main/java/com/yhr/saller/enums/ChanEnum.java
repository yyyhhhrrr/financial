package com.yhr.saller.enums;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller
 * @Author: yang
 * @CreateTime: 2019-03-29 09:17
 * @Description: ${Description}
 */
public enum ChanEnum {

    ABC("111","ABC","/opt/ABC");

    private String chanId;
    private String chanName;
    private String ftpPath,ftpUser,ftpPwd;

    private String rootDir;

    ChanEnum(String chanId, String chanName, String rootDir) {
        this.chanId = chanId;
        this.chanName = chanName;
        this.rootDir = rootDir;
    }

    public String getChanId() {
        return chanId;
    }


    public String getChanName() {
        return chanName;
    }


    public String getFtpPath() {
        return ftpPath;
    }


    public String getFtpUser() {
        return ftpUser;
    }


    public String getFtpPwd() {
        return ftpPwd;
    }


    public String getRootDir() {
        return rootDir;
    }




    /**
     * 根据渠道编号 获取渠道配置
     * @param chanId
     * @return
     */
    public static ChanEnum getByChanId(String chanId){
        for(ChanEnum chanEnum:ChanEnum.values()){
            if(chanEnum.getChanId().equals(chanId)){
                return chanEnum;
            }
        }
        return  null;
    }
}


