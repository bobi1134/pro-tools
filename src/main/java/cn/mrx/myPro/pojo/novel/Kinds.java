package cn.mrx.myPro.pojo.novel;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/2/9
 * Description:
 */
public class Kinds {

    private String name;
    private List<Novel> novels;

    /* setter and getter method */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Novel> getNovels() {
        return novels;
    }

    public void setNovels(List<Novel> novels) {
        this.novels = novels;
    }
}
