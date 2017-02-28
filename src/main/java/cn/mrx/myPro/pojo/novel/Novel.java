package cn.mrx.myPro.pojo.novel;

/**
 * Author: Mr.X
 * Date: 2017/2/9
 * Description:
 */
public class Novel {

    private String name;
    private String title;
    private String content;
    private String author;
    private String img;
    private String desc;
    private String updatetime;
    private String newest;
    private String url;
    private String kind;


    /* setter and getter method */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getNewest() {
        return newest;
    }

    public void setNewest(String newest) {
        this.newest = newest;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", img='" + img + '\'' +
                ", desc='" + desc + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", newest='" + newest + '\'' +
                ", url='" + url + '\'' +
                ", kind='" + kind + '\'' +
                '}';
    }
}
